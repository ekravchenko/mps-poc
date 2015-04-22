package org.testingzone.dbo.query;

import com.mysema.query.annotations.QueryProjection;
import org.testingzone.dbo.BinaryKey;
import org.testingzone.vo.doctor.DoctorSummaryInfo;

public class DoctorSummaryInfoWrapper extends AbstractInfoWrapper<DoctorSummaryInfo> {

    private final DoctorSummaryInfo doctorSummaryInfo;

    @QueryProjection
    public DoctorSummaryInfoWrapper(BinaryKey doctorId, String fullName, String billingNumber) {
        this.doctorSummaryInfo = new DoctorSummaryInfo(doctorId.toString(), fullName, billingNumber);
    }

    @Override
    public DoctorSummaryInfo get() {
        return doctorSummaryInfo;
    }
}
