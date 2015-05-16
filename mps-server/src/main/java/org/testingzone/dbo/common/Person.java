package org.testingzone.dbo.common;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.testingzone.dbo.base.AbstractSystemEntity;
import org.testingzone.dbo.base.BinaryKey;
import org.testingzone.dbo.contact.Contact;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "person")
@Getter
@Setter
public class Person extends AbstractSystemEntity {

    @Id
    @GeneratedValue(generator = "HBGenerator")
    @GenericGenerator(name = "HBGenerator", strategy = "org.testingzone.dbo.base.IdGenerator")
    @Column(name = "Person_PK")
    @Type(type = "org.testingzone.dbo.base.BinaryKeyType")
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

    @Override
    public BinaryKey getPrimaryKey() {
        return personPk;
    }
}
