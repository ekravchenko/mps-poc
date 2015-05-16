package org.testingzone.dbl.contact.command;

import org.testingzone.dbo.base.BinaryKey;
import org.testingzone.vo.contact.data.ContactData;

public interface SaveContactCommand {

    BinaryKey saveContact(ContactData contactData);
}
