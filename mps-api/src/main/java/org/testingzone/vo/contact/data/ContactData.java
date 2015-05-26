package org.testingzone.vo.contact.data;

import com.google.gwt.user.client.rpc.IsSerializable;

public class ContactData implements IsSerializable {
    public String contactPK;

    public String cellTelephone;
    public String faxTelephone;
    public String homeTelephone;
    public String officeTelephone;

    public String email;

    public AddressData postalAddress;
    public AddressData physicalAddress;
}
