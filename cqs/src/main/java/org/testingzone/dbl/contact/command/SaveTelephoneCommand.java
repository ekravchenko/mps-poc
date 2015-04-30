package org.testingzone.dbl.contact.command;

import org.springframework.stereotype.Component;
import org.testingzone.dbo.base.BinaryKey;
import org.testingzone.vo.contact.TelephoneType;

@Component
public class SaveTelephoneCommand {

    public BinaryKey saveTelephone(BinaryKey contactPK, TelephoneType telephoneType, String number) {
        return null;
    }
}
