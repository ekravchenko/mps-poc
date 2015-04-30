package org.testingzone.vo.contact.query;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.testingzone.vo.contact.data.AddressData;

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

    public AddressData getPostalAddress() {
        return postalAddress;
    }

    public AddressData getPhysicalAddress() {
        return physicalAddress;
    }

    public String getEmail() {
        return email;
    }
}
