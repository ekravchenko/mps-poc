package org.testingzone.dbl.doctor.query.impl;

import com.google.common.base.Strings;
import com.mysema.query.types.EntityPath;
import com.mysema.query.types.Predicate;
import com.mysema.query.types.expr.BooleanExpression;
import org.testingzone.dbl.base.query.builder.Query;
import org.testingzone.dbl.base.query.builder.QueryItem;
import org.testingzone.dbl.base.query.builder.QueryProvider;
import org.testingzone.dbl.base.query.builder.join.JoinRequest;
import org.testingzone.dbl.base.query.builder.join.LeftJoinRequest;
import org.testingzone.dbo.base.BinaryKey;
import org.testingzone.dbo.base.SafeBinaryKey;
import org.testingzone.dbo.business.QBusiness;
import org.testingzone.dbo.business.QBusinessRelationLink;
import org.testingzone.dbo.doctor.QDoctor;
import org.testingzone.vo.base.SimpleFilter;

public class DoctorSummaryQueryItems implements QueryProvider<SimpleFilter> {

    @Override
    public Query createQuery(SimpleFilter simpleFilter) {
        QDoctor doctor = QDoctor.doctor;

        QueryItem searchTextQueryItem = getSearchTextQueryItem(doctor, simpleFilter.getText());
        QueryItem businessQueryItem = getBusinessQueryItem(doctor, simpleFilter.getBusinessPK());

        return Query.EMPTY.and(searchTextQueryItem).and(businessQueryItem);
    }

    @Override
    public EntityPath getQueryRoot() {
        return QDoctor.doctor;
    }

    private QueryItem getSearchTextQueryItem(QDoctor doctor, String searchText) {
        if (!Strings.isNullOrEmpty(searchText)) {
            Predicate predicate = doctor.practiceNumber.containsIgnoreCase(searchText)
                    .or(QBusiness.business.businessName.containsIgnoreCase(searchText)
                            .or(doctor.doctorName.containsIgnoreCase(searchText)));

            return new QueryItem(predicate);
        }
        return QueryItem.EMPTY;
    }

    private QueryItem getBusinessQueryItem(QDoctor doctor, String businessPK) {
        if (!Strings.isNullOrEmpty(businessPK)) {
            QBusiness business = QBusiness.business;
            JoinRequest businessJoin = new LeftJoinRequest(doctor.business, business);
            BinaryKey businessKey = new SafeBinaryKey(businessPK).key();
            BooleanExpression businessPredicate = business.businessPk.eq(businessKey);

            QBusinessRelationLink businessRelationLink = QBusinessRelationLink.businessRelationLink;
            BooleanExpression childBusinessPredicate = businessRelationLink.businessRelationStatus.eq(1)
                    .and(businessRelationLink.businessByParentBusinessFk.businessPk.eq(businessKey));
            JoinRequest childBusinessJoin = new LeftJoinRequest(business.businessRelationLinksForChildBusinessFk, QBusinessRelationLink.businessRelationLink);

            Predicate predicate = businessPredicate.or(childBusinessPredicate);
            return new QueryItem(predicate, businessJoin, childBusinessJoin);
        }
        return QueryItem.EMPTY;
    }
}
