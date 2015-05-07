package org.testingzone.dbl.contact.query;

import org.testingzone.dbl.contact.data.EmailInfo;
import org.testingzone.dbo.base.BinaryKey;

public interface EmailQuery {

    EmailInfo getEmailInfo(BinaryKey contactPK);
}
