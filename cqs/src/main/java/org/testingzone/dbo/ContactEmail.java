package org.testingzone.dbo;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "contact_email")
public class ContactEmail extends AbstractSystemEntity {

    private static final long serialVersionUID = -6574596827261281360L;

    @Id
    @GeneratedValue(generator = "HBGenerator")
    @GenericGenerator(name = "HBGenerator", strategy = "org.testingzone.dbo.IdGenerator")
    @Column(name = "ContactEmail_PK")
    @Type(type = "org.testingzone.dbo.BinaryKeyType")
    private BinaryKey contactEmailPk;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "Contact_FK", nullable = false)
    private Contact contact;

    @Column(name = "Email", nullable = false, length = 64)
    private String email;

    @Column(name = "RowVersion", nullable = false)
    private Integer rowVersion;

    public ContactEmail() {
    }

    public BinaryKey getContactEmailPk() {
        return this.contactEmailPk;
    }

    @SuppressWarnings("UnusedDeclaration")
    public void setContactEmailPk(BinaryKey contactEmailPk) {
        this.contactEmailPk = contactEmailPk;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ContactEmail [contactEmailPk=" + contactEmailPk + ", email=" + email + "]";
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public BinaryKey getPrimaryKey() {
        return getContactEmailPk();
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
