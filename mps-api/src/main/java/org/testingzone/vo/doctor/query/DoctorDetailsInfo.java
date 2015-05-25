package org.testingzone.vo.doctor.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class DoctorDetailsInfo {

    private DoctorInfo doctorInfo;
    private DoctorContactInfo doctorContactInfo;
    private List<DoctorNetworkInfo> doctorNetworkInfos;
}
