package org.testingzone.dbl.contact.command;

import org.testingzone.dbo.base.BinaryKey;

public interface SaveEmailCommand {

    BinaryKey saveEmail(BinaryKey contactPK, String email);
}
