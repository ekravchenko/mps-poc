package org.testingzone.dbl.contact.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class TelephoneInfo {

    public final static TelephoneInfo EMPTY = new TelephoneInfo(null, null);

    private final String telephonePK;
    private final String number;

    @JsonCreator
    public TelephoneInfo(@JsonProperty("telephonePK") String telephonePK,
                         @JsonProperty("number") String number) {
        this.telephonePK = telephonePK;
        this.number = number;
    }

    public String getTelephonePK() {
        return telephonePK;
    }

    public String getNumber() {
        return number;
    }
}
