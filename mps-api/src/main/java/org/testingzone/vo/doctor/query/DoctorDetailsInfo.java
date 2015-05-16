package org.testingzone.vo.doctor.query;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public final class DoctorDetailsInfo {

    @JsonProperty
    private final DoctorInfo doctorInfo;
    @JsonProperty
    private final DoctorContactInfo doctorContactInfo;
    @JsonProperty
    private final List<DoctorNetworkInfo> doctorNetworkInfos;

    @JsonCreator
    public DoctorDetailsInfo(@JsonProperty("doctorInfo") DoctorInfo doctorInfo,
                             @JsonProperty("doctorContactInfo") DoctorContactInfo doctorContactInfo,
                             @JsonProperty("doctorNetworkInfos") List<DoctorNetworkInfo> doctorNetworkInfos) {
        this.doctorInfo = doctorInfo;
        this.doctorContactInfo = doctorContactInfo;
        this.doctorNetworkInfos = doctorNetworkInfos;
    }

    public DoctorInfo getDoctorInfo() {
        return doctorInfo;
    }

    public DoctorContactInfo getDoctorContactInfo() {
        return doctorContactInfo;
    }

    public List<DoctorNetworkInfo> getDoctorNetworkInfos() {
        return doctorNetworkInfos;
    }
}
