package org.testingzone.dbo.contact;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.testingzone.dbo.base.AbstractSystemEntity;
import org.testingzone.dbo.base.BinaryKey;

import javax.persistence.*;

@Entity
@Table(name = "contact_address")
@Getter
@Setter
public class ContactAddress extends AbstractSystemEntity {

    @Id
    @GeneratedValue(generator = "HBGenerator")
    @GenericGenerator(name = "HBGenerator", strategy = "org.testingzone.dbo.base.IdGenerator")
    @Column(name = "ContactAddress_PK")
    @Type(type = "org.testingzone.dbo.base.BinaryKeyType")
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

    @Override
    public BinaryKey getPrimaryKey() {
        return getContactAddressPk();
    }
}
