package org.testingzone.dbl.contact.command;

import org.springframework.stereotype.Component;
import org.testingzone.dbo.base.BinaryKey;
import org.testingzone.vo.contact.data.AddressData;

@Component
public class SaveAddressCommand {

    public BinaryKey saveAddress(BinaryKey binaryKey, AddressData addressData) {
        return null;
    }
}
