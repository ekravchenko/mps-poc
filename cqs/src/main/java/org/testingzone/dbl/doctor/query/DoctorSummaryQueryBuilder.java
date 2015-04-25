package org.testingzone.dbl.doctor.query;

import com.mysema.query.types.EntityPath;
import com.mysema.query.types.Predicate;
import com.mysema.query.types.expr.BooleanExpression;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testingzone.dbl.base.query.builder.AbstractQueryBuilder;
import org.testingzone.dbl.base.query.builder.Query;
import org.testingzone.dbl.base.query.builder.QueryItem;
import org.testingzone.dbl.base.query.builder.join.JoinRequest;
import org.testingzone.dbl.base.query.builder.join.LeftJoinRequest;
import org.testingzone.dbo.base.BinaryKey;
import org.testingzone.dbo.business.QBusiness;
import org.testingzone.dbo.business.QBusinessRelationLink;
import org.testingzone.dbo.doctor.QDoctor;
import org.testingzone.vo.base.SimpleFilter;

import javax.persistence.EntityManager;

@Component
public class DoctorSummaryQueryBuilder extends AbstractQueryBuilder<SimpleFilter> {

    @Autowired
    protected DoctorSummaryQueryBuilder(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Query createQuery(SimpleFilter simpleFilter) {
        QDoctor doctor = QDoctor.doctor;
        QBusiness business = QBusiness.business;

        JoinRequest businessJoinRequest = new LeftJoinRequest(doctor.business, business);
        QueryItem searchTextQueryItem = getSearchTextQueryItem(doctor, simpleFilter.getText());
        QueryItem businessQueryItem = getBusinessQueryItem(business, simpleFilter.getBusinessPK());

        return Query.EMPTY.join(businessJoinRequest).and(searchTextQueryItem).and(businessQueryItem);
    }

    @Override
    protected EntityPath getQueryRoot() {
        return QDoctor.doctor;
    }

    private QueryItem getSearchTextQueryItem(QDoctor doctor, String searchText) {
        if (StringUtils.isNotBlank(searchText)) {
            Predicate predicate = doctor.practiceNumber.containsIgnoreCase(searchText)
                    .or(QBusiness.business.businessName.containsIgnoreCase(searchText)
                            .or(doctor.doctorName.containsIgnoreCase(searchText)));

            return new QueryItem(predicate);
        }
        return QueryItem.EMPTY;
    }

    private QueryItem getBusinessQueryItem(QBusiness business, String businessPK) {
        if (StringUtils.isNotBlank(businessPK)) {
            BinaryKey businessKey = BinaryKey.valueOf(businessPK);
            BooleanExpression businessPredicate = business.businessPk.eq(businessKey);

            QBusinessRelationLink businessRelationLink = QBusinessRelationLink.businessRelationLink;
            BooleanExpression childBusinessPredicate = businessRelationLink.businessRelationStatus.eq(1)
                    .and(businessRelationLink.businessByParentBusinessFk.businessPk.eq(businessKey));
            JoinRequest childBusinessJoin = new LeftJoinRequest(business.businessRelationLinksForChildBusinessFk, QBusinessRelationLink.businessRelationLink);

            Predicate predicate = businessPredicate.or(childBusinessPredicate);
            return new QueryItem(predicate, childBusinessJoin);
        }
        return QueryItem.EMPTY;
    }
}
