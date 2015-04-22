package org.testingzone.dbo;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "business")
public class Business extends AbstractSystemEntity implements Inactivatable {

    private static final long serialVersionUID = 8378952698325060729L;

    @Id
    @Column(name = "Business_PK")
    @Type(type = "org.testingzone.dbo.BinaryKeyType")
    @GeneratedValue(generator = "HBGenerator")
    @GenericGenerator(name = "HBGenerator", strategy = "org.testingzone.dbo.IdGenerator")
    private BinaryKey businessPk;

    @Column(name = "EntityStatus_FK", nullable = false)
    private Integer entityStatus;

    @Column(name = "BusinessType_FK", nullable = false)
    private Integer businessType;

    @Column(name = "SpecialityCode")
    private Integer speciality;

    @Column(name = "SpecialityDescription", length = 250)
    private String specialityDescription;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "Contact_FK")
    private Contact contact;

    @Column(name = "BusinessName", nullable = false, length = 100)
    private String businessName;

    @Column(name = "VatNo", length = 12)
    private String vatNo;

    @Column(name = "CompanyRegNo", length = 40)
    private String companyRegNo;

    @Column(name = "BillingNumber", nullable = false, length = 13)
    private String billingNumber;

    @Column(name = "BillingIdentifier", length = 15)
    private String billingIdentifier;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "business")
    private Set<Doctor> doctors = new HashSet<>(0);

    @Column(name = "RowVersion", nullable = false)
    private Integer rowVersion;

    public Business() {
    }

    public BinaryKey getBusinessPk() {
        return this.businessPk;
    }

    public void setBusinessPk(BinaryKey businessPk) {
        this.businessPk = businessPk;
    }

    public Integer getEntityStatus() {
        return this.entityStatus;
    }

    public void setEntityStatus(Integer entityStatus) {
        this.entityStatus = entityStatus;
    }

    public Integer getBusinessType() {
        return this.businessType;
    }

    public void setBusinessType(int businessType) {
        this.businessType = businessType;
    }

    public Integer getSpeciality() {
        return this.speciality;
    }

    public void setSpeciality(Integer speciality) {
        this.speciality = speciality;
    }

    public Contact getContact() {
        return this.contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String getBusinessName() {
        return this.businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getVatNo() {
        return this.vatNo;
    }

    public void setVatNo(String vatNo) {
        this.vatNo = vatNo;
    }

    public String getCompanyRegNo() {
        return this.companyRegNo;
    }

    public void setCompanyRegNo(String companyRegNo) {
        this.companyRegNo = companyRegNo;
    }

    public String getBillingNumber() {
        return this.billingNumber;
    }

    public void setBillingNumber(String billingNumber) {
        this.billingNumber = billingNumber;
    }

    public String getBillingIdentifier() {
        return billingIdentifier;
    }

    public void setBillingIdentifier(String billingIdentifier) {
        this.billingIdentifier = billingIdentifier;
    }

    public Set<Doctor> getDoctors() {
        return this.doctors;
    }

    public void setDoctors(Set<Doctor> doctors) {
        this.doctors = doctors;
    }

    public String getSpecialityDescription() {
        return specialityDescription;
    }

    public void setSpecialityDescription(String specialityDescription) {
        this.specialityDescription = specialityDescription;
    }

    @Override
    public BinaryKey getPrimaryKey() {
        return getBusinessPk();
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
    public String toString() {
        String hexPK = (businessPk != null) ? businessPk.toString() : null;
        return "Business [businessPk=" + hexPK + "]";
    }
}
