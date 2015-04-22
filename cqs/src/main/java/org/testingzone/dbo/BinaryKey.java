package org.testingzone.dbo;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Wrapper class that should be used instead of byte arrays for primary/foreign keys in Hibernate/JPA.
 * Using byte arrays as a keys is a bad practice and not recommended by Hibernate/JPA community.
 * There are many issues related to using byte arrays.
 * <p/>
 * Please note. This class is completely immutable.
 */
public class BinaryKey implements Serializable, Comparable<BinaryKey> {

    private byte[] bytes;

    //Default constructor is needed just to be GWT compatible
    @SuppressWarnings("UnusedDeclaration")
    private BinaryKey() {
        this(null);
    }

    public BinaryKey(byte[] bytes) {
        this.bytes = deepCopy(bytes);
    }

    public static BinaryKey valueOf(byte[] bytes) {
        return new BinaryKey(bytes);
    }

    public static BinaryKey valueOfOrNull(byte[] bytes) {
        return bytes != null ? valueOf(bytes) : null;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null || !(other instanceof BinaryKey)) {
            return false;
        }
        return Arrays.equals(((BinaryKey) other).bytes, bytes);
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
