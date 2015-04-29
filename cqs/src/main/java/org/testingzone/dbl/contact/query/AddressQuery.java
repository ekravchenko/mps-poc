package org.testingzone.dbl.contact.query;

import com.google.common.base.Preconditions;
import com.mysema.query.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testingzone.dbl.contact.query.helpers.AllAddressesInfo;
import org.testingzone.dbl.contact.query.helpers.AllAddressesInfoCreator;
import org.testingzone.dbo.base.BinaryKey;
import org.testingzone.dbo.contact.QContactAddress;
import org.testingzone.dbo.contact.query.AddressInfoWrapper;
import org.testingzone.dbo.contact.query.QAddressInfoWrapper;
import org.testingzone.vo.contact.query.AddressInfo;
import org.testingzone.vo.contact.query.AddressType;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class AddressQuery {

    private EntityManager entityManager;

    @Autowired
    public AddressQuery(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public AddressInfo getAddressInfo(BinaryKey contactPK, AddressType addressType) {
        if (contactPK == null) {
            return AddressInfo.EMPTY;
        }

        Preconditions.checkNotNull(addressType, "AddressType is null");
        JPAQuery jpaQuery = new JPAQuery(entityManager);
        QContactAddress contactAddress = QContactAddress.contactAddress;
        List<AddressInfoWrapper> result = jpaQuery.from(contactAddress)
                .where(contactAddress.contact.contactPk.eq(contactPK)
                        .and(contactAddress.contactAddressType.eq(addressType.getId())))
                .list(new QAddressInfoWrapper(contactAddress.contactAddressPk, contactAddress.line1, contactAddress.line2, contactAddress.line3,
                        contactAddress.code, contactAddress.contactAddressType));

        if (result != null && !result.isEmpty()) {
            return result.iterator().next().getAddressInfo();
        }

        return AddressInfo.EMPTY;
    }

    public AllAddressesInfo getAllAddressesInfo(BinaryKey contactPK) {
        if(contactPK == null) {
            return AllAddressesInfo.EMPTY;
        }

        JPAQuery jpaQuery = new JPAQuery(entityManager);
        QContactAddress contactAddress = QContactAddress.contactAddress;
        List<AddressInfoWrapper> result = jpaQuery.from(contactAddress)
                .where(contactAddress.contact.contactPk.eq(contactPK))
                .list(new QAddressInfoWrapper(contactAddress.contactAddressPk, contactAddress.line1, contactAddress.line2, contactAddress.line3,
                        contactAddress.code, contactAddress.contactAddressType));
        AllAddressesInfoCreator allAddressesInfoWrapper = new AllAddressesInfoCreator(result);
        return allAddressesInfoWrapper.getAllAddressesInfo();
    }
}
