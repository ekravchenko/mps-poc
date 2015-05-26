package org.testingzone.vo.contact.query;

import com.google.gwt.user.client.rpc.IsSerializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.testingzone.vo.contact.data.AddressData;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class ContactInfo implements IsSerializable {

    private String contactPK;
    private String cellTelephone;
    private String faxTelephone;
    private String homeTelephone;
    private String officeTelephone;
    private AddressData postalAddress;
    private AddressData physicalAddress;
    private String email;
}
