package org.testingzone.dbo;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "contact")
public class Contact extends AbstractEntity {

    private static final long serialVersionUID = -522110502208827856L;

    @Id
    @GeneratedValue(generator = "HBGenerator")
    @GenericGenerator(name = "HBGenerator", strategy = "org.testingzone.dbo.IdGenerator")
    @Column(name = "Contact_PK", unique = true, nullable = false)
    @Type(type = "org.testingzone.dbo.BinaryKeyType")
    private BinaryKey contactPk;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "contact", cascade = CascadeType.ALL)
    private Set<ContactAddress> contactAddresses = new HashSet<>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "contact", cascade = CascadeType.ALL)
    private Set<ContactEmail> contactEmails = new HashSet<>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "contact", cascade = CascadeType.ALL)
    private Set<ContactTelephone> contactTelephones = new HashSet<>(0);

    public Contact() {
    }

    public BinaryKey getContactPk() {
        return this.contactPk;
    }

    @SuppressWarnings("UnusedDeclaration")
    public void setContactPk(BinaryKey contactPk) {
        this.contactPk = contactPk;
    }

    public Set<ContactAddress> getContactAddresses() {
        return this.contactAddresses;
    }

    public void setContactAddresses(Set<ContactAddress> contactAddresses) {
        this.contactAddresses = contactAddresses;
    }

    public Set<ContactEmail> getContactEmails() {
        return this.contactEmails;
    }

    public void setContactEmails(Set<ContactEmail> contactEmails) {
        this.contactEmails = contactEmails;
    }

    public Set<ContactTelephone> getContactTelephones() {
        return this.contactTelephones;
    }

    public void setContactTelephones(Set<ContactTelephone> contactTelephones) {
        this.contactTelephones = contactTelephones;
    }

    @Override
    public BinaryKey getPrimaryKey() {
        return getContactPk();
    }
}
