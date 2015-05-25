package org.testingzone.vo.contact.data;

import java.io.Serializable;

public class AddressData implements Serializable {

    public static final AddressData EMPTY = new AddressData();

    public String line1;
    public String line2;
    public String line3;
    public String code;
}
