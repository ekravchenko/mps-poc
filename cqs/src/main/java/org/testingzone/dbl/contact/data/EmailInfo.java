package org.testingzone.dbl.contact.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EmailInfo {

    public static final EmailInfo EMPTY = new EmailInfo(null, null);

    @JsonProperty
    private final String emailPK;
    @JsonProperty
    private final String email;

    @JsonCreator
    public EmailInfo(@JsonProperty("emailPK") String emailPK,
                     @JsonProperty("email") String email) {
        this.emailPK = emailPK;
        this.email = email;
    }

    public String getEmailPK() {
        return emailPK;
    }

    public String getEmail() {
        return email;
    }
}
