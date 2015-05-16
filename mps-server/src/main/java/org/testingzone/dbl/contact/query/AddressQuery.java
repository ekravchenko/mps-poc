package org.testingzone.dbl.contact.query;

import org.testingzone.dbl.contact.data.AddressInfo;
import org.testingzone.dbl.contact.data.AddressType;
import org.testingzone.dbl.contact.data.AllAddressesInfo;
import org.testingzone.dbo.base.BinaryKey;

public interface AddressQuery {

    AddressInfo getAddressInfo(BinaryKey contactPK, AddressType addressType);

    AllAddressesInfo getAllAddressesInfo(BinaryKey contactPK);
}

