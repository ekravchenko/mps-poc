package org.testingzone.dbl.doctor.query;

import org.testingzone.dbo.base.BinaryKey;
import org.testingzone.vo.doctor.query.DoctorInfo;

public interface DoctorQuery {

    DoctorInfo getDoctorInfo(BinaryKey doctorPK);
}
