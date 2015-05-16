package org.testingzone.dbo.base;

public final class SafeBinaryKey {

    private final BinaryKey binaryKey;

    public SafeBinaryKey(BinaryKey binaryKey) {
        this.binaryKey = binaryKey;
    }

    public SafeBinaryKey(byte[] bytes) {
        this.binaryKey = bytes != null ? new BinaryKey(bytes) : null;
    }

    public SafeBinaryKey(String hex) {
        byte[] bytes = hex != null ? HexUtils.decodeHex(hex) : null;
        this.binaryKey = bytes != null ? new BinaryKey(bytes) : null;
    }

    public String hex() {
        return binaryKey != null ? binaryKey.hex() : null;
    }

    public BinaryKey key() {
        return binaryKey;
    }
}
