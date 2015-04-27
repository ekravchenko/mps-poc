package org.testingzone.vo.doctor;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DoctorInfo {

    @JsonProperty
    private String doctorPK;
    @JsonProperty
    private String name;
    @JsonProperty
    private String surname;

    public DoctorInfo(String doctorPK, String name, String surname) {
        this.doctorPK = doctorPK;
        this.name = name;
        this.surname = surname;
    }
}
