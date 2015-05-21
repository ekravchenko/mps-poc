package org.testingzone.vo.doctor.query;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public final class DoctorContactInfo {

    public static final DoctorContactInfo EMPTY = new DoctorContactInfo(null, null, null, null, null, null);

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
}
