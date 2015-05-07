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

    public Date getCreatedTime();

    public void setCreatedTime(Date createdTime);

    public Date getUpdatedTime();

    public void setUpdatedTime(Date updatedTime);

    public String getCreatedBy();

    public void setCreatedBy(String createdBy);

    public String getUpdatedBy();

    public void setUpdatedBy(String updatedBy);

    public Integer getRowVersion();

    public void setRowVersion(Integer rowVersion);
}
