package org.testingzone.vo.contact;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class AddressInfo {

    public static final AddressInfo EMPTY = new AddressInfo(null, null, null, null, null);

    @JsonProperty
    private final String addressPK;
    @JsonProperty
    private final String line1;
    @JsonProperty
    private final String line2;
    @JsonProperty
    private final String line3;
    @JsonProperty
    private final String code;

    @JsonCreator
    public AddressInfo(@JsonProperty("addressPK") String addressPK,
                       @JsonProperty("line1") String line1,
                       @JsonProperty("line2") String line2,
                       @JsonProperty("line3") String line3,
                       @JsonProperty("code") String code) {
        this.addressPK = addressPK;
        this.line1 = line1;
        this.line2 = line2;
        this.line3 = line3;
        this.code = code;
    }

    public String getAddressPK() {
        return addressPK;
    }

    public String getLine1() {
        return line1;
    }

    public String getLine2() {
        return line2;
    }

    public String getLine3() {
        return line3;
    }

    public String getCode() {
        return code;
    }
}
