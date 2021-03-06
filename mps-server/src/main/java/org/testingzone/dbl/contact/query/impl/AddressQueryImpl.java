package org.testingzone.dbl.contact.query.impl;

import com.google.common.base.Preconditions;
import com.mysema.query.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testingzone.dbl.contact.data.AddressInfo;
import org.testingzone.dbl.contact.data.AddressType;
import org.testingzone.dbl.contact.data.AllAddressesInfo;
import org.testingzone.dbl.contact.data.AllAddressesInfoCreator;
import org.testingzone.dbl.contact.query.AddressQuery;
import org.testingzone.dbo.base.BinaryKey;
import org.testingzone.dbo.contact.QContactAddress;
import org.testingzone.dbo.contact.query.AddressInfoWrapper;
import org.testingzone.dbo.contact.query.QAddressInfoWrapper;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class AddressQueryImpl implements AddressQuery {

    private final EntityManager entityManager;

    @Autowired
    public AddressQueryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
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

    @Override
    public AllAddressesInfo getAllAddressesInfo(BinaryKey contactPK) {
        if (contactPK == null) {
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
