package org.testingzone.vo.doctor.query;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DoctorContactInfo {

    @JsonProperty
    private final String contactPK;
    @JsonProperty
    private final String cellTelephone;
    @JsonProperty
    private final String faxTelephone;
    @JsonProperty
    private final String homeTelephone;
    @JsonProperty
    private final String officeTelephone;
    @JsonProperty
    private final String email;

    @JsonCreator
    public DoctorContactInfo(@JsonProperty("contactPK") String contactPK,
                       @JsonProperty("cellTelephone") String cellTelephone,
                       @JsonProperty("faxTelephone") String faxTelephone,
                       @JsonProperty("homeTelephone") String homeTelephone,
                       @JsonProperty("officeTelephone") String officeTelephone,
                       @JsonProperty("email") String email) {
        this.contactPK = contactPK;
        this.cellTelephone = cellTelephone;
        this.faxTelephone = faxTelephone;
        this.homeTelephone = homeTelephone;
        this.officeTelephone = officeTelephone;
        this.email = email;
    }

    public String getContactPK() {
        return contactPK;
    }

    public String getCellTelephone() {
        return cellTelephone;
    }

    public String getFaxTelephone() {
        return faxTelephone;
    }

    public String getHomeTelephone() {
        return homeTelephone;
    }

    public String getOfficeTelephone() {
        return officeTelephone;
    }

    public String getEmail() {
        return email;
    }
}
