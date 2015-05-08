package org.testingzone.dbo.base;

import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Wrapper class that should be used instead of byte arrays for primary/foreign keys in Hibernate/JPA.
 * Using byte arrays as a keys is a bad practice and not recommended by Hibernate/JPA community.
 * There are many issues related to using byte arrays.
 * <p>
 * Please note. This class is completely immutable.
 */
public class BinaryKey implements Serializable, Comparable<BinaryKey> {

    private byte[] bytes;

    BinaryKey(byte[] bytes) {
        this.bytes = deepCopy(bytes);
    }

    byte[] bytes() {
        return deepCopy(bytes);
    }

    String hex() {
        return HexUtils.encodeHexString(bytes);
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
        return MoreObjects.toStringHelper(this).add("bytes", hex()).toString();
    }

    @Override
    public int compareTo(BinaryKey o) {
        if (o == null) {
            return 1;
        }
        String hex = toString();
        return hex.compareTo(o.toString());
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
