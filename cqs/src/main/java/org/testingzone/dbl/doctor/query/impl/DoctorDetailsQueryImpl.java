package org.testingzone.dbl.doctor.query.impl;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testingzone.dbl.contact.data.AllTelephonesInfo;
import org.testingzone.dbl.contact.data.EmailInfo;
import org.testingzone.dbl.contact.query.EmailQuery;
import org.testingzone.dbl.contact.query.TelephoneQuery;
import org.testingzone.dbl.doctor.query.DoctorDetailsQuery;
import org.testingzone.dbl.doctor.query.DoctorNetworkQuery;
import org.testingzone.dbl.doctor.query.DoctorQuery;
import org.testingzone.dbo.base.BinaryKey;
import org.testingzone.vo.doctor.query.DoctorContactInfo;
import org.testingzone.vo.doctor.query.DoctorDetailsInfo;
import org.testingzone.vo.doctor.query.DoctorInfo;
import org.testingzone.vo.doctor.query.DoctorNetworkInfo;

import java.util.List;

@Component
public class DoctorDetailsQueryImpl implements DoctorDetailsQuery {

    private final DoctorQuery doctorQuery;

    private final DoctorNetworkQuery doctorNetworkQuery;

    private final TelephoneQuery telephoneQuery;

    private final EmailQuery emailQuery;

    @Autowired
    public DoctorDetailsQueryImpl(DoctorQuery doctorQuery, DoctorNetworkQuery doctorNetworkQuery, TelephoneQuery telephoneQuery, EmailQuery emailQuery) {
        this.doctorQuery = doctorQuery;
        this.doctorNetworkQuery = doctorNetworkQuery;
        this.telephoneQuery = telephoneQuery;
        this.emailQuery = emailQuery;
    }

    @Override
    public DoctorDetailsInfo getDoctorDetailsInfo(BinaryKey doctorPK) {
        Preconditions.checkNotNull(doctorPK, "Doctor PK is null");

        DoctorInfo doctorInfo = doctorQuery.getDoctorInfo(doctorPK);
        List<DoctorNetworkInfo> doctorNetworkInfoList = doctorNetworkQuery.getDoctorNetworks(doctorPK);

        BinaryKey contactPK = BinaryKey.valueOf(doctorInfo.getContactPK());
        DoctorContactInfo contactInfo = getDoctorContactInfo(contactPK);

        return new DoctorDetailsInfo(doctorInfo, contactInfo, doctorNetworkInfoList);
    }

    private DoctorContactInfo getDoctorContactInfo(BinaryKey contactPK) {
        if(contactPK == null) {
            return DoctorContactInfo.EMPTY;
        }

        AllTelephonesInfo allTelephonesInfo = telephoneQuery.getAllTelephonesInfo(contactPK);
        EmailInfo emailInfo = emailQuery.getEmailInfo(contactPK);
        return new DoctorContactInfo(contactPK.toString(),
                allTelephonesInfo.getCellphone().getNumber(),
                allTelephonesInfo.getFax().getNumber(),
                allTelephonesInfo.getHome().getNumber(),
                allTelephonesInfo.getOffice().getNumber(),
                emailInfo.getEmail());
    }
}
