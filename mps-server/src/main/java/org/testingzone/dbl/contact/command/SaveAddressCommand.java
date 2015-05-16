package org.testingzone.dbl.contact.command;

import org.testingzone.dbl.contact.data.AddressType;
import org.testingzone.dbo.base.BinaryKey;
import org.testingzone.vo.contact.data.AddressData;

public interface SaveAddressCommand {

    BinaryKey saveAddress(BinaryKey contactPK, AddressType addressType, AddressData addressData);
}
