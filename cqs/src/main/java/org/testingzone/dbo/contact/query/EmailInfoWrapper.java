package org.testingzone.dbo.contact.query;

import com.mysema.query.annotations.QueryProjection;
import org.testingzone.dbo.base.BinaryKey;
import org.testingzone.vo.contact.EmailInfo;

public class EmailInfoWrapper {

    private EmailInfo emailInfo;

    @QueryProjection
    public EmailInfoWrapper(BinaryKey emailPK, String email) {
        this.emailInfo = new EmailInfo(emailPK.toString(), email);
    }

    public EmailInfo getEmailInfo() {
        return emailInfo;
    }
}
