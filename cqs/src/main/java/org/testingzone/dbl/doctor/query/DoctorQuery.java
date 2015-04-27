package org.testingzone.dbl.doctor.query;

import com.google.common.base.Preconditions;
import com.mysema.query.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testingzone.dbo.base.BinaryKey;
import org.testingzone.dbo.common.QPerson;
import org.testingzone.dbo.doctor.QDoctor;
import org.testingzone.dbo.doctor.query.DoctorInfoWrapper;
import org.testingzone.dbo.doctor.query.QDoctorInfoWrapper;
import org.testingzone.vo.doctor.DoctorInfo;

import javax.persistence.EntityManager;

@Component
public class DoctorQuery {

    private EntityManager entityManager;

    @Autowired
    public DoctorQuery(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public DoctorInfo getDoctorInfo(BinaryKey doctorPK) {
        JPAQuery jpaQuery = new JPAQuery(entityManager);
        QDoctor doctor = QDoctor.doctor;
        QPerson person = QPerson.person;
        DoctorInfoWrapper doctorInfoWrapper = jpaQuery.from(doctor)
                .leftJoin(doctor.person, person)
                .where(doctor.doctorPk.eq(doctorPK))
                .singleResult(new QDoctorInfoWrapper(doctor.doctorPk, person.name, person.surname));

        Preconditions.checkNotNull(doctorInfoWrapper, "PK [{0}] is invalid", doctorPK);
        return doctorInfoWrapper.get();
    }
}
