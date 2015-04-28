package org.testingzone.dbo.base;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Wrapper class that should be used instead of byte arrays for primary/foreign keys in Hibernate/JPA.
 * Using byte arrays as a keys is a bad practice and not recommended by Hibernate/JPA community.
 * There are many issues related to using byte arrays.
 * <p/>
 * Please note. This class is completely immutable.
 */
@SuppressWarnings("UnusedDeclaration")
public class BinaryKey implements Serializable, Comparable<BinaryKey> {

    private byte[] bytes;

    public BinaryKey(byte[] bytes) {
        this.bytes = deepCopy(bytes);
    }

    public static BinaryKey valueOf(byte[] bytes) {
        return new BinaryKey(bytes);
    }

    public static BinaryKey valueOf(String hex) {
        if (hex == null) {
            return null;
        }
        byte[] b = HexUtils.decodeHex(hex);
        return new BinaryKey(b);
    }

    public static BinaryKey valueOfOrNull(byte[] bytes) {
        return bytes != null ? valueOf(bytes) : null;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof BinaryKey)) {
            return false;
        }
        byte[] otherBytes = ((BinaryKey) other).bytes;
        return Arrays.equals(otherBytes, bytes);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(bytes);
    }

    @Override
    public String toString() {
        return HexUtils.encodeHexString(bytes);
    }

    @Override
    public int compareTo(BinaryKey o) {
        if (o == null) {
            return 1;
        }
        String hex = toString();
        return hex.compareTo(o.toString());
    }

    public byte[] getBytes() {
        return deepCopy(bytes);
    }

    public byte[] deepCopy(byte[] original) {
        if (original == null) {
            return null;
        }
        byte[] copy = new byte[original.length];
        System.arraycopy(original, 0, copy, 0, original.length);
        return copy;
    }
}
