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
    protected abstract BinaryKey getPrimaryKey();
}
