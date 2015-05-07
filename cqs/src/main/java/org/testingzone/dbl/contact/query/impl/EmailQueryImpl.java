package org.testingzone.dbl.contact.query.impl;

import com.mysema.query.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testingzone.dbl.contact.data.EmailInfo;
import org.testingzone.dbl.contact.query.EmailQuery;
import org.testingzone.dbo.base.BinaryKey;
import org.testingzone.dbo.contact.QContactEmail;
import org.testingzone.dbo.contact.query.EmailInfoWrapper;
import org.testingzone.dbo.contact.query.QEmailInfoWrapper;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class EmailQueryImpl implements EmailQuery {

    private final EntityManager entityManager;

    @Autowired
    public EmailQueryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public EmailInfo getEmailInfo(BinaryKey contactPK) {
        if (contactPK == null) {
            return EmailInfo.EMPTY;
        }

        JPAQuery jpaQuery = new JPAQuery(entityManager);
        QContactEmail contactEmail = QContactEmail.contactEmail;
        List<EmailInfoWrapper> result = jpaQuery.from(contactEmail)
                .where(contactEmail.contact.contactPk.eq(contactPK))
                .list(new QEmailInfoWrapper(contactEmail.contactEmailPk, contactEmail.email));

        if (result != null && !result.isEmpty()) {
            return result.iterator().next().getEmailInfo();
        }
        return EmailInfo.EMPTY;
    }
}
