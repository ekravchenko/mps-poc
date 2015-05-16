package org.testingzone.dbo.base;

import java.util.Date;

/**
 * Interface for classes that contain createdBy, updatedBy, rowVersion and so on fields.
 * It was created for populating these fields in  @coza.mypractice.dao.common.AbstractDetailsTransformer,
 * not duplicate code in every transformer.
 *
 * @author tamara.kyrychenko
 */
interface SystemDataAware {

    Date getCreatedTime();

    void setCreatedTime(Date createdTime);

    Date getUpdatedTime();

    void setUpdatedTime(Date updatedTime);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    String getUpdatedBy();

    void setUpdatedBy(String updatedBy);

    Integer getRowVersion();

    void setRowVersion(Integer rowVersion);
}
