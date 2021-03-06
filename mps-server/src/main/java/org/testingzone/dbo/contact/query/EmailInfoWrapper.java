package org.testingzone.dbo.contact.query;

import com.mysema.query.annotations.QueryProjection;
import org.testingzone.dbo.base.BinaryKey;
import org.testingzone.dbl.contact.data.EmailInfo;

public class EmailInfoWrapper {

    private final EmailInfo emailInfo;

    @QueryProjection
    public EmailInfoWrapper(BinaryKey emailPK, String email) {
        this.emailInfo = new EmailInfo(emailPK.toString(), email);
    }

    public EmailInfo getEmailInfo() {
        return emailInfo;
    }
}
