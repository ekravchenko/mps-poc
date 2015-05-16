package org.testingzone.dbo.contact;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.testingzone.dbo.base.AbstractSystemEntity;
import org.testingzone.dbo.base.BinaryKey;

import javax.persistence.*;

@Entity
@Table(name = "contact_email")
@Getter
@Setter
public class ContactEmail extends AbstractSystemEntity {

    @Id
    @GeneratedValue(generator = "HBGenerator")
    @GenericGenerator(name = "HBGenerator", strategy = "org.testingzone.dbo.base.IdGenerator")
    @Column(name = "ContactEmail_PK")
    @Type(type = "org.testingzone.dbo.base.BinaryKeyType")
    private BinaryKey contactEmailPk;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "Contact_FK", nullable = false)
    private Contact contact;

    @Column(name = "Email", nullable = false, length = 64)
    private String email;

    @Column(name = "RowVersion", nullable = false)
    private Integer rowVersion;

    @Override
    public BinaryKey getPrimaryKey() {
        return getContactEmailPk();
    }
}
