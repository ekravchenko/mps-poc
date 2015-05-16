package org.testingzone.dbo.base;

/**
 * Interface for classes that can be inactivated.
 *
 * @author tamara.kyrychenko
 */
@SuppressWarnings("UnusedDeclaration")
public interface Inactivating {
    void setEntityStatus(Integer entityStatus);
}
