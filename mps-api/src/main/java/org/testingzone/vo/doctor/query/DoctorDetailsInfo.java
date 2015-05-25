package org.testingzone.vo.doctor.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class DoctorDetailsInfo implements Serializable {

    private DoctorInfo doctorInfo;
    private DoctorContactInfo doctorContactInfo;
    private List<DoctorNetworkInfo> doctorNetworkInfos;
}
