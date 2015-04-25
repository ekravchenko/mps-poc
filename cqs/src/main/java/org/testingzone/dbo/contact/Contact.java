package org.testingzone.dbo.contact;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.testingzone.dbo.base.AbstractEntity;
import org.testingzone.dbo.base.BinaryKey;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "contact")
@Getter
@Setter
public class Contact extends AbstractEntity {

    private static final long serialVersionUID = -522110502208827856L;

    @Id
    @GeneratedValue(generator = "HBGenerator")
    @GenericGenerator(name = "HBGenerator", strategy = "org.testingzone.dbo.base.IdGenerator")
    @Column(name = "Contact_PK", unique = true, nullable = false)
    @Type(type = "org.testingzone.dbo.base.BinaryKeyType")
    private BinaryKey contactPk;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "contact", cascade = CascadeType.ALL)
    private Set<ContactAddress> contactAddresses = new HashSet<>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "contact", cascade = CascadeType.ALL)
    private Set<ContactEmail> contactEmails = new HashSet<>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "contact", cascade = CascadeType.ALL)
    private Set<ContactTelephone> contactTelephones = new HashSet<>(0);

    @Override
    public BinaryKey getPrimaryKey() {
        return getContactPk();
    }
}
