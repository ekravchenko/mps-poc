package org.testingzone.vo.doctor.query;

import com.google.gwt.user.client.rpc.IsSerializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class DoctorNetworkInfo implements IsSerializable {

    private String doctorNetworkPK;
    private String scheme;
    private Long dateFrom;
    private Long dateTo;
}
