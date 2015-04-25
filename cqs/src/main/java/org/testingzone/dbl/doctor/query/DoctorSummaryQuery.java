package org.testingzone.dbl.doctor.query;

import com.mysema.query.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testingzone.dbl.base.query.AbstractSummaryQuery;
import org.testingzone.dbo.business.QBusiness;
import org.testingzone.dbo.doctor.QDoctor;
import org.testingzone.dbo.doctor.query.DoctorSummaryInfoWrapper;
import org.testingzone.dbo.base.InfoWrapperList;
import org.testingzone.dbo.doctor.query.QDoctorSummaryInfoWrapper;
import org.testingzone.vo.base.PageFilter;
import org.testingzone.vo.base.SimpleFilter;
import org.testingzone.vo.doctor.DoctorSummaryInfo;

import java.util.List;

@Component
public class DoctorSummaryQuery extends AbstractSummaryQuery<SimpleFilter, DoctorSummaryInfo> {

    private DoctorSummaryQueryBuilder queryBuilder;

    @Autowired
    public DoctorSummaryQuery(DoctorSummaryQueryBuilder queryBuilder) {
        this.queryBuilder = queryBuilder;
    }

    public long count(SimpleFilter filter) {
        JPAQuery jpaQuery = queryBuilder.buildQuery(filter);
        return jpaQuery.count();
    }

    public List<DoctorSummaryInfo> getSummaryInfoList(SimpleFilter filter, PageFilter pageFilter) {
        QDoctor doctor = QDoctor.doctor;
        QBusiness business = QBusiness.business;
        JPAQuery jpaQuery = queryBuilder.buildQuery(filter, pageFilter);
        List<DoctorSummaryInfoWrapper> list = jpaQuery.list(
                new QDoctorSummaryInfoWrapper(doctor.doctorPk, doctor.doctorName, doctor.practiceNumber,
                        business.businessName, doctor.specialityDescription));
        return InfoWrapperList.unwrap(list);
    }
}
