package org.testingzone.vo.doctor;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.testingzone.vo.person.Title;

public final class DoctorInfo {

    @JsonProperty
    private final String doctorPK;
    @JsonProperty
    private final String name;
    @JsonProperty
    private final String surname;
    @JsonProperty
    private final Title title;
    @JsonProperty
    private final String speciality;
    @JsonProperty
    private final String billingNumber;
    @JsonProperty
    private final String treatingNumber;
    @JsonProperty
    private final String personPK;
    @JsonProperty
    private final String contactPK;

    @JsonCreator
    public DoctorInfo(@JsonProperty("doctorPK") String doctorPK,
                      @JsonProperty("personPK") String personPK,
                      @JsonProperty("contactPK") String contactPK,
                      @JsonProperty("name") String name,
                      @JsonProperty("surname") String surname,
                      @JsonProperty("title") Title title,
                      @JsonProperty("speciality") String speciality,
                      @JsonProperty("billingNumber") String billingNumber,
                      @JsonProperty("treatingNumber") String treatingNumber) {
        this.doctorPK = doctorPK;
        this.name = name;
        this.surname = surname;
        this.title = title;
        this.speciality = speciality;
        this.billingNumber = billingNumber;
        this.treatingNumber = treatingNumber;
        this.personPK = personPK;
        this.contactPK = contactPK;
    }

    public String getDoctorPK() {
        return doctorPK;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Title getTitle() {
        return title;
    }

    public String getSpeciality() {
        return speciality;
    }

    public String getBillingNumber() {
        return billingNumber;
    }

    public String getTreatingNumber() {
        return treatingNumber;
    }

    public String getPersonPK() {
        return personPK;
    }

    public String getContactPK() {
        return contactPK;
    }
}
