package org.testingzone.vo.contact.data;

import com.google.gwt.user.client.rpc.IsSerializable;

public class AddressData implements IsSerializable {

    public static final AddressData EMPTY = new AddressData();

    public String line1;
    public String line2;
    public String line3;
    public String code;
}
