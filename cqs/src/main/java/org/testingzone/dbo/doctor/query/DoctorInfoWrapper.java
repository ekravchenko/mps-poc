package org.testingzone.dbo.doctor.query;

import com.mysema.query.annotations.QueryProjection;
import org.testingzone.dbo.base.AbstractInfoWrapper;
import org.testingzone.dbo.base.BinaryKey;
import org.testingzone.vo.doctor.DoctorInfo;

public class DoctorInfoWrapper extends AbstractInfoWrapper<DoctorInfo> {

    private DoctorInfo doctorInfo;

    @QueryProjection
    public DoctorInfoWrapper(BinaryKey doctorPK, String name, String surname) {
        this.doctorInfo = new DoctorInfo(doctorPK.toString(), name, surname);
    }

    @Override
    public DoctorInfo get() {
        return doctorInfo;
    }
}
