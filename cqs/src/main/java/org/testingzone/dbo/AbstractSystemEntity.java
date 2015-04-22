package org.testingzone.dbo;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@MappedSuperclass
public abstract class AbstractSystemEntity extends AbstractEntity implements SystemDataAware {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CreatedTime", nullable = false, length = 23)
    private Date createdTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UpdatedTime", nullable = false, length = 23)
    private Date updatedTime;

    @Column(name = "CreatedBy", length = 100, nullable = false)
    private String createdBy;

    @Column(name = "UpdatedBy", length = 100, nullable = false)
    private String updatedBy;

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Integer getRowVersion() {
        return 0;
    }

    public void setRowVersion(Integer rowVersion) {
    }

    public byte[] getPrimaryKeyBytes() {
        BinaryKey primaryKey = getPrimaryKey();
        return primaryKey != null ? primaryKey.getBytes() : null;
    }
}
