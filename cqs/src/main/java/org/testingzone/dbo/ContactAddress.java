package org.testingzone.dbo;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "contact_address")
public class ContactAddress extends AbstractSystemEntity {

    private static final long serialVersionUID = -5041719374955574500L;

    @Id
    @GeneratedValue(generator = "HBGenerator")
    @GenericGenerator(name = "HBGenerator", strategy = "org.testingzone.dbo.IdGenerator")
    @Column(name = "ContactAddress_PK")
    @Type(type = "org.testingzone.dbo.BinaryKeyType")
    private BinaryKey contactAddressPk;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Contact_FK", nullable = false)
    private Contact contact;

    @Column(name = "ContactAddressType_FK", nullable = false)
    private int contactAddressType;

    @Column(name = "Line1", nullable = false, length = 100)
    private String line1;

    @Column(name = "Line2", length = 100)
    private String line2;

    @Column(name = "Line3", length = 100)
    private String line3;

    @Column(name = "Code", length = 10)
    private String code;

    @Column(name = "RowVersion", nullable = false)
    private Integer rowVersion;

    public ContactAddress() {
    }

    public BinaryKey getContactAddressPk() {
        return this.contactAddressPk;
    }

    @SuppressWarnings("UnusedDeclaration")
    public void setContactAddressPk(BinaryKey contactAddressPk) {
        this.contactAddressPk = contactAddressPk;
    }

    public int getContactAddressType() {
        return this.contactAddressType;
    }

    public void setContactAddressType(int contactAddressType) {
        this.contactAddressType = contactAddressType;
    }

    public String getLine1() {
        return this.line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return this.line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getLine3() {
        return this.line3;
    }

    public void setLine3(String line3) {
        this.line3 = line3;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
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
        return getContactAddressPk();
    }
}
