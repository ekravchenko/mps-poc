package org.testingzone.dbo.doctor;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.testingzone.dbo.base.AbstractSystemEntity;
import org.testingzone.dbo.base.BinaryKey;
import org.testingzone.dbo.base.Inactivating;
import org.testingzone.dbo.doctor.Doctor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "doctor_network")
@Getter
@Setter
public class DoctorNetwork extends AbstractSystemEntity implements Inactivating {

    private static final long serialVersionUID = 7053737996759608058L;

    @Id
    @GeneratedValue(generator = "HBGenerator")
    @GenericGenerator(name = "HBGenerator", strategy = "org.testingzone.dbo.base.IdGenerator")
    @Column(name = "DoctorNetwork_PK")
    @Type(type = "org.testingzone.dbo.base.BinaryKeyType")
    private BinaryKey doctorNetworkPk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Doctor_FK", nullable = false)
    private Doctor doctor;

    @Column(name = "SchemeDescription", nullable = false, length = 128)
    private String schemeDescription;

    @Temporal(TemporalType.DATE)
    @Column(name = "DateFrom", nullable = false, length = 10)
    private Date dateFrom;

    @Temporal(TemporalType.DATE)
    @Column(name = "DateTo", length = 10)
    private Date dateTo;

    @Column(name = "EntityStatus_FK", nullable = false)
    private Integer entityStatus;

    @Column(name = "RowVersion", nullable = false)
    private Integer rowVersion;

    @Override
    public BinaryKey getPrimaryKey() {
        return doctorNetworkPk;
    }
}
