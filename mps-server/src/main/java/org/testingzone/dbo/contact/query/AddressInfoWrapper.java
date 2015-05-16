package org.testingzone.dbo.contact.query;

import com.mysema.query.annotations.QueryProjection;
import lombok.Getter;
import org.testingzone.dbl.contact.data.AddressInfo;
import org.testingzone.dbl.contact.data.AddressType;
import org.testingzone.dbo.base.BinaryKey;
import org.testingzone.vo.contact.data.AddressData;

@Getter
public class AddressInfoWrapper {

    private final AddressInfo addressInfo;
    private final AddressType addressType;

    @QueryProjection
    public AddressInfoWrapper(BinaryKey addressPK, String line1, String line2, String line3, String code, Integer addressType) {
        AddressData addressData = new AddressData();
        addressData.line1 = line1;
        addressData.line2 = line2;
        addressData.line3 = line3;
        addressData.code = code;
        this.addressInfo = new AddressInfo(addressPK.toString(), addressData);
        this.addressType = AddressType.valueOf(addressType);
    }
}
