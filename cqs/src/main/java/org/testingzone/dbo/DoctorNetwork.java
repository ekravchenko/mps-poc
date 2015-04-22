package org.testingzone.dbo;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "doctor_network")
public class DoctorNetwork extends AbstractSystemEntity implements Inactivatable {

    private static final long serialVersionUID = 7053737996759608058L;

    @Id
    @GeneratedValue(generator = "HBGenerator")
    @GenericGenerator(name = "HBGenerator", strategy = "org.testingzone.dbo.IdGenerator")
    @Column(name = "DoctorNetwork_PK")
    @Type(type = "org.testingzone.dbo.BinaryKeyType")
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

    public DoctorNetwork() {
    }

    public BinaryKey getDoctorNetworkPk() {
        return doctorNetworkPk;
    }

    @SuppressWarnings("UnusedDeclaration")
    public void setDoctorNetworkPk(BinaryKey doctorNetworkPk) {
        this.doctorNetworkPk = doctorNetworkPk;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getSchemeDescription() {
        return schemeDescription;
    }

    public void setSchemeDescription(String schemeDescription) {
        this.schemeDescription = schemeDescription;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    @Override
    public void setEntityStatus(Integer entityStatus) {
        this.entityStatus = entityStatus;
    }

    public Integer getEntityStatus() {
        return this.entityStatus;
    }

    @Override
    public BinaryKey getPrimaryKey() {
        return getDoctorNetworkPk();
    }

    @Override
    public Integer getRowVersion() {
        return rowVersion;
    }

    @Override
    public void setRowVersion(Integer rowVersion) {
        this.rowVersion = rowVersion;
    }
}
