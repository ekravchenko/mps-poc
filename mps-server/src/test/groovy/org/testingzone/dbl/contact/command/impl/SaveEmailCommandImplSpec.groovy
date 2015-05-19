package org.testingzone.dbl.contact.command.impl

import org.springframework.beans.factory.annotation.Autowired
import org.testingzone.dbl.BaseSpecification
import org.testingzone.dbl.contact.command.SaveEmailCommand
import org.testingzone.dbl.contact.repository.ContactRepository
import org.testingzone.dbl.contact.repository.EmailRepository
import org.testingzone.dbo.base.BinaryKey
import org.testingzone.dbo.base.SafeBinaryKey
import org.testingzone.dbo.contact.Contact
import org.testingzone.dbo.contact.ContactEmail
import spock.lang.Ignore

class SaveEmailCommandImplSpec extends BaseSpecification {

    @Autowired
    private SaveEmailCommand saveEmailCommand;
    @Autowired
    private EmailRepository emailRepository;
    @Autowired
    private ContactRepository contactRepository;

    BinaryKey contactPK;

    def setup() {
        Contact contact = new Contact();
        contact = contactRepository.save(contact);
        contactPK = contact.getContactPk();
    }

    def "save new email"() {
        given:
        String email = "test@test.com";

        when:
        BinaryKey emailPK = saveEmailCommand.saveEmail(contactPK, email);
        then:
        emailPK != null;

        when:
        ContactEmail contactEmail = emailRepository.findOne(emailPK);
        then:
        contactEmail != null;
        contactEmail.getEmail() == email;
    }

    @Ignore
    def "update existing email"() {
        // TODO Build this test as soon as there is a proper way to load initial Data into test DB
    }

    def "save email with null email string"() {
        given:
        String email = null;

        when:
        saveEmailCommand.saveEmail(contactPK, email);
        then:
        def e = thrown(NullPointerException)
        e.message == "Email is null"
    }

    def "save email with null contact pk"() {
        given:
        contactPK = null;
        String email = "test@test.com";

        when:
        saveEmailCommand.saveEmail(contactPK, email);
        then:
        def e = thrown(NullPointerException)
        e.message == "Contact PK is null"
    }

    def "save email with not existing contact pk"() {
        given:
        contactPK = new SafeBinaryKey("1111").key();
        String email = "test@test.com";

        when:
        saveEmailCommand.saveEmail(contactPK, email);
        then:
        def e = thrown(IllegalArgumentException)
        e.message == "Error finding contact with pk 1111"
    }
}
