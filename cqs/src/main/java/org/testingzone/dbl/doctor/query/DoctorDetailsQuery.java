package org.testingzone.dbl.doctor.query;

import org.testingzone.dbo.base.BinaryKey;
import org.testingzone.vo.doctor.query.DoctorDetailsInfo;

public interface DoctorDetailsQuery {

    DoctorDetailsInfo getDoctorDetailsInfo(BinaryKey doctorPK);
}
