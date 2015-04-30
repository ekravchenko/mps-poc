package org.testingzone.vo.contact.data;

import org.testingzone.vo.contact.TelephoneType;

public class TelephoneData {

    private String number;
    private TelephoneType telephoneType;

    public TelephoneData(String number, TelephoneType telephoneType) {
        this.number = number;
        this.telephoneType = telephoneType;
    }

    public String getNumber() {
        return number;
    }

    public TelephoneType getTelephoneType() {
        return telephoneType;
    }
}
