package org.testingzone.dbl.contact.command;

import org.springframework.stereotype.Component;
import org.testingzone.dbl.contact.data.TelephoneType;
import org.testingzone.dbo.base.BinaryKey;

@Component
public class SaveTelephoneCommand {

    public BinaryKey saveTelephone(BinaryKey contactPK, TelephoneType telephoneType, String number) {
        return null;
    }
}
