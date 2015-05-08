package org.testingzone.dbo.doctor.query;

import com.mysema.query.annotations.QueryProjection;
import org.testingzone.dbo.base.AbstractInfoWrapper;
import org.testingzone.dbo.base.BinaryKey;
import org.testingzone.dbo.base.SafeBinaryKey;
import org.testingzone.vo.doctor.query.DoctorInfo;
import org.testingzone.vo.person.Title;

public class DoctorInfoWrapper extends AbstractInfoWrapper<DoctorInfo> {

    private final DoctorInfo doctorInfo;

    @QueryProjection
    public DoctorInfoWrapper(BinaryKey doctorPK, BinaryKey personPK, BinaryKey contactPK, String name, String surname,
                             Integer title, String speciality, String billingNumber, String treatingNumber) {
        this.doctorInfo = new DoctorInfo(
                new SafeBinaryKey(doctorPK).hex(),
                new SafeBinaryKey(personPK).hex(),
                new SafeBinaryKey(contactPK).hex(),
                name, surname, Title.valueOf(title), speciality, billingNumber, treatingNumber);
    }

    @Override
    public DoctorInfo get() {
        return doctorInfo;
    }
}
