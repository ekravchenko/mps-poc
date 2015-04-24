package org.testingzone.vo.doctor;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DoctorSummaryInfo {

    @JsonProperty
    private final String id;
    @JsonProperty
    private final String fullName;
    @JsonProperty
    private final String billingPracticeNumber;

    @JsonCreator
    public DoctorSummaryInfo(
            @JsonProperty("id")
            String id,
            @JsonProperty("fullName")
            String fullName,
            @JsonProperty("billingPracticeNumber")
            String billingPracticeNumber) {
        this.id = id;
        this.fullName = fullName;
        this.billingPracticeNumber = billingPracticeNumber;
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
}
