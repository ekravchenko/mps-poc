package org.testingzone.dbl.doctor.query;

import com.mysema.query.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testingzone.dbl.base.query.AbstractSummaryQuery;
import org.testingzone.dbl.base.query.builder.QueryBuilder;
import org.testingzone.dbl.base.query.builder.join.JoinRequest;
import org.testingzone.dbl.base.query.builder.join.LeftJoinRequest;
import org.testingzone.dbl.base.query.builder.sort.SortExpression;
import org.testingzone.dbo.business.QBusiness;
import org.testingzone.dbo.doctor.QDoctor;
import org.testingzone.dbo.doctor.query.DoctorSummaryInfoWrapper;
import org.testingzone.dbo.base.InfoWrapperList;
import org.testingzone.dbo.doctor.query.QDoctorSummaryInfoWrapper;
import org.testingzone.vo.base.PageFilter;
import org.testingzone.vo.base.SimpleFilter;
import org.testingzone.vo.base.SortFilter;
import org.testingzone.vo.doctor.DoctorSummaryInfo;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class DoctorSummaryQuery extends AbstractSummaryQuery<SimpleFilter, DoctorSummaryInfo> {

    private EntityManager entityManager;

    @Autowired
    public DoctorSummaryQuery(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public long count(SimpleFilter filter) {
        JPAQuery jpaQuery = queryBuilder().filter(filter).build();
        return jpaQuery.count();
    }

    public List<DoctorSummaryInfo> getSummaryInfoList(SimpleFilter filter, PageFilter pageFilter, SortFilter sortFilter) {
        QDoctor doctor = QDoctor.doctor;
        QBusiness business = QBusiness.business;
        JoinRequest businessJoin = new LeftJoinRequest(doctor.business, business);
        SortExpression sort = sortExpression(sortFilter);

        JPAQuery jpaQuery = queryBuilder().joins(businessJoin).filter(filter).page(pageFilter).sort(sort).build();
        List<DoctorSummaryInfoWrapper> list = jpaQuery.list(
                new QDoctorSummaryInfoWrapper(doctor.doctorPk, doctor.doctorName, doctor.practiceNumber,
                        business.businessName, doctor.specialityDescription));
        return InfoWrapperList.unwrap(list);
    }

    private QueryBuilder<SimpleFilter> queryBuilder() {
        return new QueryBuilder<>(entityManager, new DoctorSummaryQueryItems());
    }

    private SortExpression sortExpression(SortFilter sortFilter) {
        return new DoctorSortExpressionProvider().build(sortFilter);
    }
}
