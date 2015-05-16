package org.testingzone.dbl.contact.data;

import org.testingzone.vo.contact.data.AddressData;

public final class AddressInfo {

    public static final AddressInfo EMPTY = new AddressInfo(null, new AddressData());

    private final String addressPK;
    private final AddressData addressData;

    public AddressInfo(String addressPK,
                       AddressData addressData) {
        this.addressPK = addressPK;
        this.addressData = addressData;
    }

    public String getAddressPK() {
        return addressPK;
    }

    public AddressData getAddressData() {
        return addressData;
    }
}
