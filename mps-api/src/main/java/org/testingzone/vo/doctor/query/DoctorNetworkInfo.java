package org.testingzone.vo.doctor.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class DoctorNetworkInfo implements Serializable {

    private String doctorNetworkPK;
    private String scheme;
    private Long dateFrom;
    private Long dateTo;
}
