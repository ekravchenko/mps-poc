package org.testingzone.dbl.contact.query.impl;

import com.google.common.base.Preconditions;
import com.mysema.query.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testingzone.dbl.contact.data.AllTelephonesInfo;
import org.testingzone.dbl.contact.data.AllTelephonesInfoCreator;
import org.testingzone.dbl.contact.data.TelephoneInfo;
import org.testingzone.dbl.contact.data.TelephoneType;
import org.testingzone.dbl.contact.query.TelephoneQuery;
import org.testingzone.dbo.base.BinaryKey;
import org.testingzone.dbo.contact.QContactTelephone;
import org.testingzone.dbo.contact.query.QTelephoneInfoWrapper;
import org.testingzone.dbo.contact.query.TelephoneInfoWrapper;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class TelephoneQueryImpl implements TelephoneQuery {

    private final EntityManager entityManager;

    @Autowired
    public TelephoneQueryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public TelephoneInfo getTelephoneInfo(BinaryKey contactPK, TelephoneType telephoneType) {
        if (contactPK == null) {
            return TelephoneInfo.EMPTY;
        }
        Preconditions.checkNotNull(telephoneType, "TelephoneType shouldn't be null");
        QContactTelephone telephone = QContactTelephone.contactTelephone;
        JPAQuery jpaQuery = new JPAQuery(entityManager);
        List<TelephoneInfoWrapper> telephones = jpaQuery.from(telephone)
                .where(telephone.contact.contactPk.eq(contactPK)
                        .and(telephone.contactTelephoneType.eq(telephoneType.getId())))
                .list(new QTelephoneInfoWrapper(telephone.contactTelephonePk, telephone.number, telephone.contactTelephoneType));

        if (telephones != null && !telephones.isEmpty()) {
            return telephones.iterator().next().getTelephoneInfo();
        }
        return TelephoneInfo.EMPTY;
    }

    @Override
    public AllTelephonesInfo getAllTelephonesInfo(BinaryKey contactPK) {
        if (contactPK == null) {
            return AllTelephonesInfo.EMPTY;
        }
        QContactTelephone telephone = QContactTelephone.contactTelephone;
        JPAQuery jpaQuery = new JPAQuery(entityManager);
        List<TelephoneInfoWrapper> contactTelephoneInfoList = jpaQuery.from(telephone)
                .where(telephone.contact.contactPk.eq(contactPK))
                .list(new QTelephoneInfoWrapper(telephone.contactTelephonePk, telephone.number, telephone.contactTelephoneType));
        AllTelephonesInfoCreator allTelephoneWrapper = new AllTelephonesInfoCreator(contactTelephoneInfoList);
        return allTelephoneWrapper.getAllTelephonesInfo();
    }
}
