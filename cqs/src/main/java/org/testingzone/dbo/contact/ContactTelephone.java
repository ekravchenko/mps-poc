package org.testingzone.dbo.contact;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.testingzone.dbo.base.AbstractSystemEntity;
import org.testingzone.dbo.base.BinaryKey;

import javax.persistence.*;

@Entity
@Table(name = "contact_telephone")
@Getter
@Setter
public class ContactTelephone extends AbstractSystemEntity {

    @Id
    @GeneratedValue(generator = "HBGenerator")
    @GenericGenerator(name = "HBGenerator", strategy = "org.testingzone.dbo.base.IdGenerator")
    @Column(name = "ContactTelephone_PK", unique = true, nullable = false)
    @Type(type = "org.testingzone.dbo.base.BinaryKeyType")
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

    @Override
    public BinaryKey getPrimaryKey() {
        return getContactTelephonePk();
    }
}
