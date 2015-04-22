package org.testingzone.dbo;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "person")
public class Person extends AbstractSystemEntity {

    private static final long serialVersionUID = -4058537201160548558L;

    @Id
    @GeneratedValue(generator = "HBGenerator")
    @GenericGenerator(name = "HBGenerator", strategy = "org.testingzone.dbo.IdGenerator")
    @Column(name = "Person_PK")
    @Type(type = "org.testingzone.dbo.BinaryKeyType")
    private BinaryKey personPk;

    @Column(name = "Gender_FK")
    private Integer personGender;

    @Column(name = "Title_FK", nullable = false)
    private Integer personTitle;

    @Column(name = "Language_FK")
    private Integer personLanguage;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "Contact_FK")
    private Contact contact;

    @Column(name = "IdentityNumber", length = 50)
    private String identityNumber;

    @Column(name = "Name", nullable = false, length = 50)
    private String name;

    @Column(name = "MiddleName", length = 50)
    private String middleName;

    @Column(name = "Surname", nullable = false, length = 50)
    private String surname;

    @Column(name = "Initials", length = 10)
    private String initials;

    @Temporal(TemporalType.DATE)
    @Column(name = "DateOfBirth", length = 10)
    private Date dateOfBirth;

    @Column(name = "Country_FK")
    private Integer country;

    @Column(name = "IdIsPassportFlag", nullable = false)
    private boolean idIsPassportFlag;

    @Column(name = "RowVersion", nullable = false)
    private Integer rowVersion;

    public Person() {
    }

    public BinaryKey getPersonPk() {
        return this.personPk;
    }

    @SuppressWarnings("UnusedDeclaration")
    public void setPersonPk(BinaryKey personPk) {
        this.personPk = personPk;
    }

    public Integer getPersonGender() {
        return this.personGender;
    }

    public void setPersonGender(Integer personGender) {
        this.personGender = personGender;
    }

    public Integer getPersonTitle() {
        return this.personTitle;
    }

    public void setPersonTitle(Integer personTitle) {
        this.personTitle = personTitle;
    }

    public Integer getPersonLanguage() {
        return this.personLanguage;
    }

    public void setPersonLanguage(Integer personLanguage) {
        this.personLanguage = personLanguage;
    }

    public Contact getContact() {
        return this.contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String getIdentityNumber() {
        return this.identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getCountry() {
        return country;
    }

    public void setCountry(Integer country) {
        this.country = country;
    }

    public boolean isIdIsPassportFlag() {
        return idIsPassportFlag;
    }

    public void setIdIsPassportFlag(boolean idIsPassportFlag) {
        this.idIsPassportFlag = idIsPassportFlag;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
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
    public BinaryKey getPrimaryKey() {
        return getPersonPk();
    }
}
