package org.testingzone.dbo.base;

import java.io.Serializable;

/**
 * The entities that take part in transformations (VO->Entity and wise versa)
 * should implement this interface
 */
public abstract class AbstractEntity implements Serializable {

    /**
     * Get primary key of current entity
     *
     * @return PrimaryKey of entity
     */
    public abstract BinaryKey getPrimaryKey();

    public byte[] getId() {
        BinaryKey primaryKey = getPrimaryKey();
        return primaryKey != null ? primaryKey.getBytes() : null;
    }
}
