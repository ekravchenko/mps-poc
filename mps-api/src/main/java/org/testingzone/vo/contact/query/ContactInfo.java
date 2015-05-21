package org.testingzone.vo.contact.query;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;
import org.testingzone.vo.contact.data.AddressData;

@Value
public final class ContactInfo {

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
    private final AddressData postalAddress;
    @JsonProperty
    private final AddressData physicalAddress;
    @JsonProperty
    private final String email;

    @JsonCreator
    public ContactInfo(@JsonProperty("contactPK") String contactPK,
                       @JsonProperty("cellTelephone") String cellTelephone,
                       @JsonProperty("faxTelephone") String faxTelephone,
                       @JsonProperty("homeTelephone") String homeTelephone,
                       @JsonProperty("officeTelephone") String officeTelephone,
                       @JsonProperty("postalAddress") AddressData postalAddressData,
                       @JsonProperty("physicalAddress") AddressData physicalAddressData,
                       @JsonProperty("email") String email) {
        this.contactPK = contactPK;
        this.cellTelephone = cellTelephone;
        this.faxTelephone = faxTelephone;
        this.homeTelephone = homeTelephone;
        this.officeTelephone = officeTelephone;
        this.postalAddress = postalAddressData;
        this.physicalAddress = physicalAddressData;
        this.email = email;
    }
}
