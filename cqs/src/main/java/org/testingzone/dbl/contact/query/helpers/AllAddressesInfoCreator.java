package org.testingzone.dbl.contact.query.helpers;

import org.testingzone.dbo.contact.query.AddressInfoWrapper;
import org.testingzone.vo.contact.query.AddressInfo;
import org.testingzone.vo.contact.query.AddressType;

import java.util.List;

public class AllAddressesInfoCreator {

    private final AllAddressesInfo allAddressesInfo;

    public AllAddressesInfoCreator(List<AddressInfoWrapper> addressInfoWrappers) {
        AddressInfo postal = AddressInfo.EMPTY;
        AddressInfo physical = AddressInfo.EMPTY;

        for (AddressInfoWrapper addressInfoWrapper : addressInfoWrappers) {
            if (addressInfoWrapper.getAddressType() == AddressType.PHYSICAL) {
                physical = addressInfoWrapper.getAddressInfo();
            }
            if (addressInfoWrapper.getAddressType() == AddressType.POSTAL) {
                postal = addressInfoWrapper.getAddressInfo();
            }
        }

        this.allAddressesInfo = new AllAddressesInfo(physical, postal);
    }

    public AllAddressesInfo getAllAddressesInfo() {
        return allAddressesInfo;
    }
}
