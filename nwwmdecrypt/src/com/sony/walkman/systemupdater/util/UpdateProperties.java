package com.sony.walkman.systemupdater.util;

public class UpdateProperties {
    private byte[] mIvBytes;
    private byte[] mKeyBytes;

    public UpdateProperties(String keyHex, String ivHex) {
        mKeyBytes = hexToBytes(keyHex);
        mIvBytes = hexToBytes(ivHex);
    }

    private static byte[] hexToBytes(String hex) {
        int len = hex.length();
        byte[] out = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            out[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4)
                                + Character.digit(hex.charAt(i + 1), 16));
        }
        return out;
    }

    public byte[] getKeyBytes() {
        return this.mKeyBytes;
    }

    public byte[] getIvBytes() {
        return this.mIvBytes;
    }
}
