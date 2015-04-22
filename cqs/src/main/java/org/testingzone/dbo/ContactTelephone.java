package org.testingzone.dbo;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "contact_telephone")
public class ContactTelephone extends AbstractSystemEntity {

    private static final long serialVersionUID = -6405116051757608439L;

    @Id
    @GeneratedValue(generator = "HBGenerator")
    @GenericGenerator(name = "HBGenerator", strategy = "org.testingzone.dbo.IdGenerator")
    @Column(name = "ContactTelephone_PK", unique = true, nullable = false)
    @Type(type = "org.testingzone.dbo.BinaryKeyType")
    private BinaryKey contactTelephonePk;


    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "Contact_FK", nullable = false)
    private Contact contact;

    @Column(name = "ContactTelephoneType_FK", length = 15)
    private Integer contactTelephoneType;

    @Column(name = "Code", length = 15)
    private String code;

    @Column(name = "Number", nullable = false, length = 20)
    private String number;

    @Column(name = "Prefered", nullable = false)
    private int prefered;

    @Column(name = "RowVersion", nullable = false)
    private Integer rowVersion;

    public ContactTelephone() {
    }

    public BinaryKey getContactTelephonePk() {
        return this.contactTelephonePk;
    }

    @SuppressWarnings("UnusedDeclaration")
    public void setContactTelephonePk(BinaryKey contactTelephonePk) {
        this.contactTelephonePk = contactTelephonePk;
    }

    public Integer getContactTelephoneType() {
        return this.contactTelephoneType;
    }

    public void setContactTelephoneType(Integer contactTelephoneType) {
        this.contactTelephoneType = contactTelephoneType;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getPrefered() {
        return this.prefered;
    }

    public void setPrefered(int prefered) {
        this.prefered = prefered;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
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
        return getContactTelephonePk();
    }
}
