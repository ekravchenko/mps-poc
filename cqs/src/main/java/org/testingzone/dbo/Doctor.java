package org.testingzone.dbo;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "doctor")
public class Doctor extends AbstractSystemEntity implements Inactivatable {

    private static final long serialVersionUID = -5453870138924517248L;

    @Id
    @GeneratedValue(generator = "HBGenerator")
    @GenericGenerator(name = "HBGenerator", strategy = "org.testingzone.dbo.IdGenerator")
    @Column(name = "Doctor_PK", unique = true, nullable = false)
    @Type(type = "org.testingzone.dbo.BinaryKeyType")
    private BinaryKey doctorPk;

    @Column(name = "EntityStatus_FK", nullable = false)
    private Integer entityStatus;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "Business_FK", nullable = false)
    private Business business;

    @Column(name = "Capacity_FK")
    private Integer capacity;

    @Column(name = "SpecialityCode")
    private Integer speciality;

    @Column(name = "SpecialityDescription", length = 250)
    private String specialityDescription;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "Person_FK")
    private Person person;

    @Column(name = "DoctorName", nullable = false, length = 101 /* name + " " + surname */)
    private String doctorName;

    @Column(name = "PracticeNumber", length = 20)
    private String practiceNumber;

    @Column(name = "HPCNumber", length = 50)
    private String hpcnumber;

    @Column(name = "Qualification")
    private String qualification;

    @Column(name = "SmsFlag", nullable = false)
    private boolean smsFlag;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "doctor", cascade = CascadeType.ALL)
    private Set<DoctorNetwork> doctorNetworks = new HashSet<>(0);

    @Column(name = "RowVersion", nullable = false)
    private Integer rowVersion;

    public Doctor() {
    }

    public BinaryKey getDoctorPk() {
        return this.doctorPk;
    }

    @SuppressWarnings("UnusedDeclaration")
    public void setDoctorPk(BinaryKey doctorPk) {
        this.doctorPk = doctorPk;
    }

    public Integer getEntityStatus() {
        return this.entityStatus;
    }

    public Business getBusiness() {
        return this.business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    @SuppressWarnings("UnusedDeclaration")
    public Integer getCapacity() {
        return this.capacity;
    }

    @SuppressWarnings("UnusedDeclaration")
    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getSpeciality() {
        return this.speciality;
    }

    public void setSpeciality(Integer speciality) {
        this.speciality = speciality;
    }

    public Person getPerson() {
        return this.person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getDoctorName() {
        return this.doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getPracticeNumber() {
        return this.practiceNumber;
    }

    public void setPracticeNumber(String practiceNumber) {
        this.practiceNumber = practiceNumber;
    }

    @SuppressWarnings("UnusedDeclaration")
    public String getHpcnumber() {
        return this.hpcnumber;
    }

    @SuppressWarnings("UnusedDeclaration")
    public void setHpcnumber(String hpcnumber) {
        this.hpcnumber = hpcnumber;
    }

    public String getQualification() {
        return this.qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    @SuppressWarnings("UnusedDeclaration")
    public Set<DoctorNetwork> getDoctorNetworks() {
        return doctorNetworks;
    }

    @SuppressWarnings("UnusedDeclaration")
    public void setDoctorNetworks(Set<DoctorNetwork> doctorNetworks) {
        this.doctorNetworks = doctorNetworks;
    }

    @Override
    public String toString() {
        return "Doctor [doctorPk=" + doctorPk + "]";
    }

    public String getSpecialityDescription() {
        return specialityDescription;
    }

    public void setSpecialityDescription(String specialityDescription) {
        this.specialityDescription = specialityDescription;
    }

    @SuppressWarnings("UnusedDeclaration")
    public boolean isSmsFlag() {
        return smsFlag;
    }

    @SuppressWarnings("UnusedDeclaration")
    public void setSmsFlag(boolean smsFlag) {
        this.smsFlag = smsFlag;
    }

    @Override
    public Integer getRowVersion() {
        return rowVersion;
    }

    @Override
    public void setRowVersion(Integer rowVersion) {
        this.rowVersion = rowVersion;
    }

    @Override
    public void setEntityStatus(Integer entityStatus) {
        this.entityStatus = entityStatus;
    }

    @Override
    public BinaryKey getPrimaryKey() {
        return getDoctorPk();
    }
}
