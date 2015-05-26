package org.testingzone.vo.doctor.query;

import com.google.gwt.user.client.rpc.IsSerializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class DoctorDetailsInfo implements IsSerializable {

    private DoctorInfo doctorInfo;
    private DoctorContactInfo doctorContactInfo;
    private List<DoctorNetworkInfo> doctorNetworkInfos;
}
