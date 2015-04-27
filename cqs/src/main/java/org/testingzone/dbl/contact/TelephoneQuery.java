package org.testingzone.dbl.contact;

import com.mysema.query.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testingzone.dbo.base.BinaryKey;
import org.testingzone.dbo.contact.QContactTelephone;
import org.testingzone.dbo.contact.query.*;
import org.testingzone.vo.contact.AllTelephonesInfo;
import org.testingzone.vo.contact.TelephoneInfo;
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

        QContactTelephone telephone = QContactTelephone.contactTelephone;
        JPAQuery jpaQuery = new JPAQuery(entityManager);
        List<TelephoneInfoWrapper> telephones = jpaQuery.from(telephone)
                .where(telephone.contact.contactPk.eq(contactPK)
                        .and(telephone.contactTelephoneType.eq(telephoneType.getId())))
                .list(new QTelephoneInfoWrapper(telephone.contactTelephonePk, telephone.number));

        if (telephones != null && !telephones.isEmpty()) {
            return telephones.iterator().next().get();
        }
        return TelephoneInfo.EMPTY;
    }

    public AllTelephonesInfo getAllTelephonesInfo(BinaryKey contactPK) {
        if (contactPK == null) {
            return AllTelephonesInfo.EMPTY;
        }
        QContactTelephone telephone = QContactTelephone.contactTelephone;
        JPAQuery jpaQuery = new JPAQuery(entityManager);
        List<ContactTelephoneInfo> contactTelephoneInfoList = jpaQuery.from(telephone)
                .where(telephone.contact.contactPk.eq(contactPK))
                .list(new QContactTelephoneInfo(telephone.contactTelephonePk, telephone.number, telephone.contactTelephoneType));
        AllTelephoneInfoWrapper allTelephoneWrapper = new AllTelephoneInfoWrapper(contactTelephoneInfoList);
        return allTelephoneWrapper.getAllTelephonesInfo();
    }
}
