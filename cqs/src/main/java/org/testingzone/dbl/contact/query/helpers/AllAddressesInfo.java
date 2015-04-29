package org.testingzone.dbl.contact.query.helpers;

import org.testingzone.vo.contact.query.AddressInfo;

public final class AllAddressesInfo {

    public static final AllAddressesInfo EMPTY = new AllAddressesInfo(AddressInfo.EMPTY, AddressInfo.EMPTY);

    private AddressInfo physical;

    private AddressInfo postal;

    public AllAddressesInfo(AddressInfo physical, AddressInfo postal) {
        this.physical = physical;
        this.postal = postal;
    }

    public AddressInfo getPhysical() {
        return physical;
    }

    public AddressInfo getPostal() {
        return postal;
    }
}
