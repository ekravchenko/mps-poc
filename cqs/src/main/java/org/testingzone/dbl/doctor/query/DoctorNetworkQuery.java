package org.testingzone.dbl.doctor.query;

import com.google.common.base.Preconditions;
import com.mysema.query.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testingzone.dbo.base.BinaryKey;
import org.testingzone.dbo.base.InfoWrapperList;
import org.testingzone.dbo.doctor.QDoctor;
import org.testingzone.dbo.doctor.QDoctorNetwork;
import org.testingzone.dbo.doctor.query.DoctorNetworkInfoWrapper;
import org.testingzone.dbo.doctor.query.QDoctorNetworkInfoWrapper;
import org.testingzone.vo.doctor.query.DoctorNetworkInfo;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class DoctorNetworkQuery {

    private EntityManager entityManager;

    @Autowired
    public DoctorNetworkQuery(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<DoctorNetworkInfo> getDoctorNetworks(BinaryKey doctorPK) {
        Preconditions.checkNotNull(doctorPK, "Doctor PK is null");
        JPAQuery jpaQuery = new JPAQuery(entityManager);
        QDoctorNetwork doctorNetwork = QDoctorNetwork.doctorNetwork;
        QDoctor doctor = QDoctor.doctor;
        List<DoctorNetworkInfoWrapper> result = jpaQuery.from(doctorNetwork)
                .leftJoin(doctorNetwork.doctor, doctor)
                .where(doctor.doctorPk.eq(doctorPK))
                .list(new QDoctorNetworkInfoWrapper(doctorNetwork.doctorNetworkPk, doctorNetwork.schemeDescription,
                        doctorNetwork.dateFrom, doctorNetwork.dateTo));
        return InfoWrapperList.unwrap(result);
    }
}
