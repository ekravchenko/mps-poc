package org.testingzone.dbo.base;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter
@Setter
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
}
