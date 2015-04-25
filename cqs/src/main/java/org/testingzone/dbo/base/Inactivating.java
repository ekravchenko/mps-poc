package org.testingzone.dbo.base;

/**
 * Interface for classes that can be inactivated.
 *
 * @author tamara.kyrychenko
 */
@SuppressWarnings("UnusedDeclaration")
public interface Inactivating {
    public void setEntityStatus(Integer entityStatus);
}
