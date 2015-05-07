package org.testingzone.dbl.contact.command;

import org.testingzone.dbl.contact.data.TelephoneType;
import org.testingzone.dbo.base.BinaryKey;

public interface SaveTelephoneCommand {

    BinaryKey saveTelephone(BinaryKey contactPK, TelephoneType telephoneType, String number);
}
