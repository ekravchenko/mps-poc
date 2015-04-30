package org.testingzone.dbl.contact.command;

import org.mockito.internal.util.Checks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testingzone.dbl.contact.data.AddressType;
import org.testingzone.dbl.contact.data.TelephoneType;
import org.testingzone.dbl.contact.repository.ContactRepository;
import org.testingzone.dbo.base.BinaryKey;
import org.testingzone.dbo.contact.Contact;
import org.testingzone.vo.contact.data.ContactData;

@Component
public class SaveContactCommand {

    private ContactRepository contactRepository;
    private SaveAddressCommand saveAddressCommand;
    private SaveTelephoneCommand saveTelephoneCommand;
    private SaveEmailCommand saveEmailCommand;

    @Autowired
    public SaveContactCommand(ContactRepository contactRepository, SaveAddressCommand saveAddressCommand, SaveTelephoneCommand saveTelephoneCommand, SaveEmailCommand saveEmailCommand) {
        this.contactRepository = contactRepository;
        this.saveAddressCommand = saveAddressCommand;
        this.saveTelephoneCommand = saveTelephoneCommand;
        this.saveEmailCommand = saveEmailCommand;
    }

    public BinaryKey saveContact(ContactData contactData) {
        Checks.checkNotNull(contactData, "ContactData is null");

        BinaryKey contactPK = BinaryKey.valueOf(contactData.contactPK);
        if (contactPK == null) {
            Contact contact = new Contact();
            contact = contactRepository.save(contact);
            contactPK = contact.getContactPk();
        }

        if (contactData.cellTelephone != null) {
            saveTelephoneCommand.saveTelephone(contactPK, TelephoneType.MOBILE, contactData.cellTelephone);
        }
        if (contactData.faxTelephone != null) {
            saveTelephoneCommand.saveTelephone(contactPK, TelephoneType.FAX, contactData.faxTelephone);
        }
        if (contactData.homeTelephone != null) {
            saveTelephoneCommand.saveTelephone(contactPK, TelephoneType.HOME, contactData.homeTelephone);
        }
        if (contactData.officeTelephone != null) {
            saveTelephoneCommand.saveTelephone(contactPK, TelephoneType.OFFICE, contactData.officeTelephone);
        }
        if (contactData.email != null) {
            saveEmailCommand.saveEmail(contactPK, contactData.email);
        }
        if (contactData.postalAddress != null) {
            saveAddressCommand.saveAddress(contactPK, AddressType.POSTAL, contactData.postalAddress);
        }
        if (contactData.physicalAddress != null) {
            saveAddressCommand.saveAddress(contactPK, AddressType.PHYSICAL, contactData.physicalAddress);
        }
        return contactPK;
    }
}
