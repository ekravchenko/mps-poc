package org.testingzone.dbl.contact.command.impl;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.testingzone.dbl.contact.command.SaveEmailCommand;
import org.testingzone.dbl.contact.repository.ContactRepository;
import org.testingzone.dbl.contact.repository.EmailRepository;
import org.testingzone.dbo.base.BinaryKey;
import org.testingzone.dbo.base.RowVersion;
import org.testingzone.dbo.contact.Contact;
import org.testingzone.dbo.contact.ContactEmail;

@Transactional
@Component
public class SaveEmailCommandImpl implements SaveEmailCommand {

    private final EmailRepository emailRepository;
    private final ContactRepository contactRepository;

    @Autowired
    public SaveEmailCommandImpl(EmailRepository emailRepository, ContactRepository contactRepository) {
        this.emailRepository = emailRepository;
        this.contactRepository = contactRepository;
    }

    @Override
    public BinaryKey saveEmail(BinaryKey contactPK, String email) {
        Preconditions.checkNotNull(contactPK, "Contact PK is null");
        Preconditions.checkNotNull(email, "Email is null");

        ContactEmail contactEmail = getEmail(contactPK);
        contactEmail.setEmail(email);
        contactEmail = emailRepository.save(contactEmail);
        return contactEmail.getContactEmailPk();
    }

    private ContactEmail getEmail(BinaryKey contactPK) {
        Preconditions.checkNotNull(contactPK, "Contact PK is null");
        ContactEmail email = emailRepository.findEmail(contactPK);

        if (email == null) {
            Contact contact = contactRepository.getOne(contactPK);

            email = new ContactEmail();
            email.setContact(contact);
            email.setRowVersion(RowVersion.DEFAULT);
        }

        return email;
    }
}
