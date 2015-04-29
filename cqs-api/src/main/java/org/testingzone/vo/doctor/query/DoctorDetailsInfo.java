package org.testingzone.vo.doctor.query;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.testingzone.vo.contact.query.ContactInfo;

import java.util.List;

public class DoctorDetailsInfo {

    @JsonProperty
    private DoctorInfo doctorInfo;
    @JsonProperty
    private ContactInfo contactInfo;
    @JsonProperty
    private List<DoctorNetworkInfo> doctorNetworkInfos;

    @JsonCreator
    public DoctorDetailsInfo(@JsonProperty("doctorInfo") DoctorInfo doctorInfo,
                             @JsonProperty("contactInfo") ContactInfo contactInfo,
                             @JsonProperty("doctorNetworkInfos") List<DoctorNetworkInfo> doctorNetworkInfos) {
        this.doctorInfo = doctorInfo;
        this.contactInfo = contactInfo;
        this.doctorNetworkInfos = doctorNetworkInfos;
    }

    public DoctorInfo getDoctorInfo() {
        return doctorInfo;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public List<DoctorNetworkInfo> getDoctorNetworkInfos() {
        return doctorNetworkInfos;
    }
}
