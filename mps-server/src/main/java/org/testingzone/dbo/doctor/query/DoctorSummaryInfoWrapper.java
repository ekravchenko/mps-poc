package org.testingzone.dbo.doctor.query;

import com.mysema.query.annotations.QueryProjection;
import org.testingzone.dbo.base.AbstractInfoWrapper;
import org.testingzone.dbo.base.BinaryKey;
import org.testingzone.dbo.base.SafeBinaryKey;
import org.testingzone.vo.doctor.query.DoctorSummaryInfo;

public class DoctorSummaryInfoWrapper extends AbstractInfoWrapper<DoctorSummaryInfo> {

    private final DoctorSummaryInfo doctorSummaryInfo;

    @QueryProjection
    public DoctorSummaryInfoWrapper(BinaryKey doctorId, String fullName, String billingNumber, String practiceName, String speciality) {
        this.doctorSummaryInfo = new DoctorSummaryInfo(new SafeBinaryKey(doctorId).hex(), fullName, billingNumber, practiceName, speciality);
    }

    @Override
    public DoctorSummaryInfo get() {
        return doctorSummaryInfo;
    }
}
