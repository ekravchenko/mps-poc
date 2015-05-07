package org.testingzone.dbl.doctor.query.impl;

import com.google.common.base.Preconditions;
import com.mysema.query.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testingzone.dbl.doctor.query.DoctorQuery;
import org.testingzone.dbo.base.BinaryKey;
import org.testingzone.dbo.business.QBusiness;
import org.testingzone.dbo.common.QPerson;
import org.testingzone.dbo.contact.QContact;
import org.testingzone.dbo.doctor.QDoctor;
import org.testingzone.dbo.doctor.query.DoctorInfoWrapper;
import org.testingzone.dbo.doctor.query.QDoctorInfoWrapper;
import org.testingzone.vo.doctor.query.DoctorInfo;

import javax.persistence.EntityManager;

@Component
public class DoctorQueryImpl implements DoctorQuery {

    private final EntityManager entityManager;

    @Autowired
    public DoctorQueryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public DoctorInfo getDoctorInfo(BinaryKey doctorPK) {
        JPAQuery jpaQuery = new JPAQuery(entityManager);
        QDoctor doctor = QDoctor.doctor;
        QPerson person = QPerson.person;
        QContact contact = QContact.contact;
        QBusiness business = QBusiness.business;
        DoctorInfoWrapper doctorInfoWrapper = jpaQuery.from(doctor)
                .leftJoin(doctor.person, person).leftJoin(person.contact, contact).leftJoin(doctor.business, business)
                .where(doctor.doctorPk.eq(doctorPK))
                .singleResult(new QDoctorInfoWrapper(doctor.doctorPk, person.personPk, contact.contactPk, person.name, person.surname,
                        person.personTitle, doctor.specialityDescription, business.billingNumber, doctor.practiceNumber));

        Preconditions.checkArgument(doctorInfoWrapper != null, "PK '%s' is invalid", doctorPK);
        return doctorInfoWrapper.get();
    }
}
