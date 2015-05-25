package org.testingzone.vo.doctor.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class DoctorNetworkInfo {

    private String doctorNetworkPK;
    private String scheme;
    private Long dateFrom;
    private Long dateTo;
}
