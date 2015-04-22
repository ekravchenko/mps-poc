package org.testingzone.dbl.doctor.query;

import com.mysema.query.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testingzone.dbo.QDoctor;
import org.testingzone.dbo.query.DoctorSummaryInfoWrapper;
import org.testingzone.dbo.query.InfoWrapperList;
import org.testingzone.dbo.query.QDoctorSummaryInfoWrapper;
import org.testingzone.vo.doctor.DoctorSummaryInfo;
import org.testingzone.vo.doctor.SimpleFilter;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class DoctorSummaryQuery {

    private final static QDoctor Q_DOCTOR = QDoctor.doctor;

    @Autowired
    private EntityManager entityManager;


    public long count(SimpleFilter filter) {
        JPAQuery jpaQuery = new JPAQuery(entityManager);
        return jpaQuery.from(Q_DOCTOR).count();
    }

    public List<DoctorSummaryInfo> getDoctorSummaries(SimpleFilter filter) {
        JPAQuery jpaQuery = new JPAQuery(entityManager);
        List<DoctorSummaryInfoWrapper> list = jpaQuery.from(Q_DOCTOR).list(new QDoctorSummaryInfoWrapper(Q_DOCTOR.doctorPk, Q_DOCTOR.doctorName, Q_DOCTOR.practiceNumber));
        return InfoWrapperList.unwrap(list);
    }
}
