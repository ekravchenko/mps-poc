package org.testingzone.dbo.business;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.testingzone.dbo.base.AbstractSystemEntity;
import org.testingzone.dbo.base.BinaryKey;

import javax.persistence.*;

@Entity
@Table(name = "business_relation_link")
@Getter
@Setter
public class BusinessRelationLink extends AbstractSystemEntity {

    @Id
    @Column(name = "BusinessRelationLink_PK")
    @Type(type = "org.testingzone.dbo.base.BinaryKeyType")
    @GeneratedValue(generator = "HBGenerator")
    @GenericGenerator(name = "HBGenerator", strategy = "org.testingzone.dbo.base.IdGenerator")
    private BinaryKey businessRelationLinkPk;

    @Column(name = "BusinessRelationType_FK", nullable = false)
    private int businessRelationType;

    @Column(name = "BusinessRelationStatus_FK", nullable = false)
    private int businessRelationStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ParentBusiness_FK", referencedColumnName = "Business_PK", nullable = false)
    private Business businessByParentBusinessFk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ChildBusiness_FK", referencedColumnName = "Business_PK", nullable = false)
    private Business businessByChildBusinessFk;

    @Column(name = "RowVersion", nullable = false)
    private Integer rowVersion;

    @Override
    public BinaryKey getPrimaryKey() {
        return businessRelationLinkPk;
    }
}
