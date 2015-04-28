package org.testingzone.vo.doctor;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class DoctorNetworkInfo {

    @JsonProperty
    private final String doctorNetworkPK;
    @JsonProperty
    private final String scheme;
    @JsonProperty
    private final Long dateFrom;
    @JsonProperty
    private final Long dateTo;

    @JsonCreator
    public DoctorNetworkInfo(@JsonProperty("doctorNetworkPK") String doctorNetworkPK,
                             @JsonProperty("scheme") String scheme,
                             @JsonProperty("dateFrom") Long dateFrom,
                             @JsonProperty("dateTo") Long dateTo) {
        this.doctorNetworkPK = doctorNetworkPK;
        this.scheme = scheme;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public String getDoctorNetworkPK() {
        return doctorNetworkPK;
    }

    public String getScheme() {
        return scheme;
    }

    public long getDateFrom() {
        return dateFrom;
    }

    public long getDateTo() {
        return dateTo;
    }
}
