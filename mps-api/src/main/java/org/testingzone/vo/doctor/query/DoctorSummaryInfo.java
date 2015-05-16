package org.testingzone.vo.doctor.query;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DoctorSummaryInfo {

    @JsonProperty
    private final String id;
    @JsonProperty
    private final String fullName;
    @JsonProperty
    private final String billingPracticeNumber;
    @JsonProperty
    private final String practiceName;
    @JsonProperty
    private final String speciality;

    @JsonCreator
    public DoctorSummaryInfo(
            @JsonProperty("id")
            String id,
            @JsonProperty("fullName")
            String fullName,
            @JsonProperty("billingPracticeNumber")
            String billingPracticeNumber,
            @JsonProperty("practiceName")
            String practiceName,
            @JsonProperty("speciality")
            String speciality) {
        this.id = id;
        this.fullName = fullName;
        this.billingPracticeNumber = billingPracticeNumber;
        this.practiceName = practiceName;
        this.speciality = speciality;
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getBillingPracticeNumber() {
        return billingPracticeNumber;
    }

    public String getSpeciality() {
        return speciality;
    }

    public String getPracticeName() {
        return practiceName;
    }
}
