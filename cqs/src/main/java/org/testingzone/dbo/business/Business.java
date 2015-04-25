package org.testingzone.dbo.business;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.testingzone.dbo.contact.Contact;
import org.testingzone.dbo.doctor.Doctor;
import org.testingzone.dbo.base.AbstractSystemEntity;
import org.testingzone.dbo.base.BinaryKey;
import org.testingzone.dbo.base.Inactivating;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "business")
@Getter
@Setter
public class Business extends AbstractSystemEntity implements Inactivating {

    @Id
    @Column(name = "Business_PK")
    @Type(type = "org.testingzone.dbo.base.BinaryKeyType")
    @GeneratedValue(generator = "HBGenerator")
    @GenericGenerator(name = "HBGenerator", strategy = "org.testingzone.dbo.base.IdGenerator")
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "businessByChildBusinessFk", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Set<BusinessRelationLink> businessRelationLinksForChildBusinessFk = new HashSet<>(0);

    @Override
    public BinaryKey getPrimaryKey() {
        return getBusinessPk();
    }
}
