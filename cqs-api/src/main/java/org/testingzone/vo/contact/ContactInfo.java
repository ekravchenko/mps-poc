package org.testingzone.vo.contact;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class ContactInfo {

    @JsonProperty
    private final TelephoneInfo cellTelephoneInfo;
    @JsonProperty
    private final TelephoneInfo faxTelephoneInfo;
    @JsonProperty
    private final TelephoneInfo homeTelephoneInfo;
    @JsonProperty
    private final TelephoneInfo officeTelephoneInfo;
    @JsonProperty
    private final AddressInfo postalAddressInfo;
    @JsonProperty
    private final AddressInfo physicalAddressInfo;
    @JsonProperty
    private final EmailInfo emailInfo;

    @JsonCreator
    public ContactInfo(@JsonProperty("cellTelephoneInfo") TelephoneInfo cellTelephoneInfo,
                       @JsonProperty("faxTelephoneInfo") TelephoneInfo faxTelephoneInfo,
                       @JsonProperty("homeTelephoneInfo") TelephoneInfo homeTelephoneInfo,
                       @JsonProperty("officeTelephoneInfo") TelephoneInfo officeTelephoneInfo,
                       @JsonProperty("postalAddressInfo") AddressInfo postalAddressInfo,
                       @JsonProperty("physicalAddressInfo") AddressInfo physicalAddressInfo,
                       @JsonProperty("emailInfo") EmailInfo emailInfo) {
        this.cellTelephoneInfo = cellTelephoneInfo;
        this.faxTelephoneInfo = faxTelephoneInfo;
        this.homeTelephoneInfo = homeTelephoneInfo;
        this.officeTelephoneInfo = officeTelephoneInfo;
        this.postalAddressInfo = postalAddressInfo;
        this.physicalAddressInfo = physicalAddressInfo;
        this.emailInfo = emailInfo;
    }

    public TelephoneInfo getCellTelephoneInfo() {
        return cellTelephoneInfo;
    }

    public TelephoneInfo getFaxTelephoneInfo() {
        return faxTelephoneInfo;
    }

    public TelephoneInfo getHomeTelephoneInfo() {
        return homeTelephoneInfo;
    }

    public TelephoneInfo getOfficeTelephoneInfo() {
        return officeTelephoneInfo;
    }

    public AddressInfo getPostalAddressInfo() {
        return postalAddressInfo;
    }

    public AddressInfo getPhysicalAddressInfo() {
        return physicalAddressInfo;
    }

    public EmailInfo getEmailInfo() {
        return emailInfo;
    }
}
