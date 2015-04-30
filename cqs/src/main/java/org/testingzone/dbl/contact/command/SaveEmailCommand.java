package org.testingzone.dbl.contact.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.testingzone.dbl.contact.repository.ContactRepository;
import org.testingzone.dbl.contact.repository.EmailRepository;
import org.testingzone.dbo.base.BinaryKey;
import org.testingzone.dbo.contact.ContactEmail;

public class SaveEmailCommand {

    private EmailRepository emailRepository;
    private ContactRepository contactRepository;

    @Autowired
    public SaveEmailCommand(EmailRepository emailRepository, ContactRepository contactRepository) {
        this.emailRepository = emailRepository;
        this.contactRepository = contactRepository;
    }

    public BinaryKey saveEmail(BinaryKey contactPK, String email) {
        return null;
    }

    private ContactEmail getEmail(BinaryKey contactPK) {
        return null;
    }
}
