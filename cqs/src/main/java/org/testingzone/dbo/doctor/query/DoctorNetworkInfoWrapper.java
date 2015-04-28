package org.testingzone.dbo.doctor.query;

import com.mysema.query.annotations.QueryProjection;
import org.testingzone.dbo.base.AbstractInfoWrapper;
import org.testingzone.dbo.base.BinaryKey;
import org.testingzone.vo.doctor.DoctorNetworkInfo;

import java.util.Date;

public final class DoctorNetworkInfoWrapper extends AbstractInfoWrapper<DoctorNetworkInfo> {

    private final DoctorNetworkInfo doctorNetworkInfo;

    @QueryProjection
    public DoctorNetworkInfoWrapper(BinaryKey doctorNetworkPK, String scheme, Date dateFrom, Date dateTo) {
        long dateFromTime = dateFrom != null ? dateFrom.getTime() : null;
        long dateToTime = dateTo != null ? dateTo.getTime() : null;
        this.doctorNetworkInfo = new DoctorNetworkInfo(doctorNetworkPK.toString(), scheme, dateFromTime, dateToTime);
    }

    @Override
    public DoctorNetworkInfo get() {
        return doctorNetworkInfo;
    }
}
