package org.testingzone.dbl.doctor.query;

import org.testingzone.dbo.base.BinaryKey;
import org.testingzone.vo.doctor.query.DoctorNetworkInfo;

import java.util.List;

public interface DoctorNetworkQuery {

    List<DoctorNetworkInfo> getDoctorNetworks(BinaryKey doctorPK);
}
