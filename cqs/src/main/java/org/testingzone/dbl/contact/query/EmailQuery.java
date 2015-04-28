package org.testingzone.dbl.contact.query;

import com.mysema.query.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testingzone.dbo.base.BinaryKey;
import org.testingzone.dbo.contact.QContactEmail;
import org.testingzone.dbo.contact.query.EmailInfoWrapper;
import org.testingzone.dbo.contact.query.QEmailInfoWrapper;
import org.testingzone.vo.contact.EmailInfo;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class EmailQuery {

    private EntityManager entityManager;

    @Autowired
    public EmailQuery(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

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
