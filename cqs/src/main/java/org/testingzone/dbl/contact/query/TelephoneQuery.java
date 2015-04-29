package org.testingzone.dbl.contact.query;

import com.google.common.base.Preconditions;
import com.mysema.query.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testingzone.dbl.contact.query.helpers.AllTelephonesInfo;
import org.testingzone.dbl.contact.query.helpers.AllTelephonesInfoCreator;
import org.testingzone.dbo.base.BinaryKey;
import org.testingzone.dbo.contact.QContactTelephone;
import org.testingzone.dbo.contact.query.QTelephoneInfoWrapper;
import org.testingzone.dbo.contact.query.TelephoneInfoWrapper;
import org.testingzone.vo.contact.query.TelephoneInfo;
import org.testingzone.vo.contact.TelephoneType;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class TelephoneQuery {

    private EntityManager entityManager;

    @Autowired
    public TelephoneQuery(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

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
