package org.testingzone.dbo.doctor.query;

import com.mysema.query.annotations.QueryProjection;
import org.testingzone.dbo.base.AbstractInfoWrapper;
import org.testingzone.dbo.base.BinaryKey;
import org.testingzone.vo.doctor.query.DoctorInfo;
import org.testingzone.vo.person.Title;

import java.util.Objects;

public class DoctorInfoWrapper extends AbstractInfoWrapper<DoctorInfo> {

    private final DoctorInfo doctorInfo;

    @QueryProjection
    public DoctorInfoWrapper(BinaryKey doctorPK, BinaryKey personPK, BinaryKey contactPK, String name, String surname,
                             Integer title, String speciality, String billingNumber, String treatingNumber) {
        this.doctorInfo = new DoctorInfo(
                Objects.toString(doctorPK, null),
                Objects.toString(personPK, null),
                Objects.toString(contactPK, null),
                name, surname, Title.valueOf(title), speciality, billingNumber, treatingNumber);
    }

    @Override
    public DoctorInfo get() {
        return doctorInfo;
    }
}
