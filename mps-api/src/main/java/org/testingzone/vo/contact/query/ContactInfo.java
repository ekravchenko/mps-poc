package org.testingzone.vo.contact.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.testingzone.vo.contact.data.AddressData;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class ContactInfo implements Serializable {

    private String contactPK;
    private String cellTelephone;
    private String faxTelephone;
    private String homeTelephone;
    private String officeTelephone;
    private AddressData postalAddress;
    private AddressData physicalAddress;
    private String email;
}
