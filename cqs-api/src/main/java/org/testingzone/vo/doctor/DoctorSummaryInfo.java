package org.testingzone.vo.doctor;

public class DoctorSummaryInfo {

    private final String id;
    private final String fullName;
    private final String billingPracticeNumber;

    public DoctorSummaryInfo(String id, String fullName, String billingPracticeNumber) {
        this.id = id;
        this.fullName = fullName;
        this.billingPracticeNumber = billingPracticeNumber;
    }

    public String getDoctorId() {
        return id;
    }

    public String getDoctorFullName() {
        return fullName;
    }

    public String getBillingPracticeNumber() {
        return billingPracticeNumber;
    }
}
