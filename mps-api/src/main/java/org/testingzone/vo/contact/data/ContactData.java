package org.testingzone.vo.contact.data;

import java.io.Serializable;

public class ContactData implements Serializable {
    public String contactPK;

    public String cellTelephone;
    public String faxTelephone;
    public String homeTelephone;
    public String officeTelephone;

    public String email;

    public AddressData postalAddress;
    public AddressData physicalAddress;
}
