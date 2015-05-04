package org.testingzone.dbl.contact.command;

import com.google.common.base.Preconditions;
import org.hibernate.hql.internal.ast.tree.AbstractNullnessCheckNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testingzone.dbl.contact.data.TelephoneType;
import org.testingzone.dbl.contact.repository.ContactRepository;
import org.testingzone.dbl.contact.repository.TelephoneRepository;
import org.testingzone.dbo.base.BinaryKey;
import org.testingzone.dbo.base.RowVersion;
import org.testingzone.dbo.contact.Contact;
import org.testingzone.dbo.contact.ContactTelephone;

@Component
public class SaveTelephoneCommand {

    private ContactRepository contactRepository;
    private TelephoneRepository telephoneRepository;

    @Autowired
    public SaveTelephoneCommand(ContactRepository contactRepository, TelephoneRepository telephoneRepository) {
        this.contactRepository = contactRepository;
        this.telephoneRepository = telephoneRepository;
    }

    public BinaryKey saveTelephone(BinaryKey contactPK, TelephoneType telephoneType, String number) {
        Preconditions.checkNotNull(contactPK, "Contact PK is null");
        Preconditions.checkNotNull(telephoneType, "TelephoneType is null");
        Preconditions.checkNotNull(number, "Telephone number is null");

        ContactTelephone telephone = getTelephoneReference(contactPK, telephoneType);
        telephone.setNumber(number);

        telephone = telephoneRepository.save(telephone);
        return telephone.getContactTelephonePk();
    }

    private ContactTelephone getTelephoneReference(BinaryKey contactPK, TelephoneType telephoneType) {
        Preconditions.checkNotNull(contactPK, "Contact PK is null");
        Preconditions.checkNotNull(telephoneType, "TelephoneType is null");

        ContactTelephone telephone = telephoneRepository.findTelephone(contactPK, telephoneType.getId());

        if (telephone == null) {
            Contact contact = contactRepository.getOne(contactPK);

            telephone = new ContactTelephone();
            telephone.setContact(contact);
            telephone.setContactTelephoneType(telephoneType.getId());
            telephone.setRowVersion(RowVersion.DEFAULT);
        }

        return telephone;
    }
}
