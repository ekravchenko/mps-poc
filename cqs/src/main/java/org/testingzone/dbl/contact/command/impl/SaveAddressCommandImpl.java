package org.testingzone.dbl.contact.command.impl;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.testingzone.dbl.contact.command.SaveAddressCommand;
import org.testingzone.dbl.contact.data.AddressType;
import org.testingzone.dbl.contact.repository.AddressRepository;
import org.testingzone.dbl.contact.repository.ContactRepository;
import org.testingzone.dbo.base.BinaryKey;
import org.testingzone.dbo.base.RowVersion;
import org.testingzone.dbo.contact.Contact;
import org.testingzone.dbo.contact.ContactAddress;
import org.testingzone.vo.contact.data.AddressData;

@Transactional
@Component
public class SaveAddressCommandImpl implements SaveAddressCommand {

    private final AddressRepository addressRepository;
    private final ContactRepository contactRepository;

    @Autowired
    public SaveAddressCommandImpl(AddressRepository addressRepository, ContactRepository contactRepository) {
        this.addressRepository = addressRepository;
        this.contactRepository = contactRepository;
    }

    @Override
    public BinaryKey saveAddress(BinaryKey contactPK, AddressType addressType, AddressData addressData) {
        Preconditions.checkNotNull(contactPK, "Contact PK is null");
        Preconditions.checkNotNull(addressType, "AddressType is null");
        Preconditions.checkNotNull(addressData, "AddressData is null");

        ContactAddress address = getAddressReference(contactPK, addressType);
        address.setCode(addressData.code);
        address.setLine1(addressData.line1);
        address.setLine2(addressData.line2);
        address.setLine3(addressData.line3);

        address = addressRepository.save(address);
        return address.getContactAddressPk();
    }

    private ContactAddress getAddressReference(BinaryKey contactPK, AddressType addressType) {
        Preconditions.checkNotNull(contactPK, "Contact PK is null");
        Preconditions.checkNotNull(addressType, "AddressType is null");

        ContactAddress address = addressRepository.findAddress(contactPK, addressType.getId());

        if (address == null) {
            Contact contact = contactRepository.getOne(contactPK);
            address = new ContactAddress();
            address.setContact(contact);
            address.setContactAddressType(addressType.getId());
            address.setRowVersion(RowVersion.DEFAULT);
            return address;
        }

        return address;
    }
}
