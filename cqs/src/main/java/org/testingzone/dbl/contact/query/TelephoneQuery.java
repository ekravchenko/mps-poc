package org.testingzone.dbl.contact.query;

import org.testingzone.dbl.contact.data.AllTelephonesInfo;
import org.testingzone.dbl.contact.data.TelephoneInfo;
import org.testingzone.dbl.contact.data.TelephoneType;
import org.testingzone.dbo.base.BinaryKey;

public interface TelephoneQuery {
    
    TelephoneInfo getTelephoneInfo(BinaryKey contactPK, TelephoneType telephoneType);

    AllTelephonesInfo getAllTelephonesInfo(BinaryKey contactPK);
}
