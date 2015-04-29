package org.testingzone.dbo.contact.query;

import com.mysema.query.annotations.QueryProjection;
import lombok.Getter;
import org.testingzone.dbo.base.BinaryKey;
import org.testingzone.vo.contact.query.AddressInfo;
import org.testingzone.vo.contact.query.AddressType;

@Getter
public class AddressInfoWrapper {

    private AddressInfo addressInfo;
    private AddressType addressType;

    @QueryProjection
    public AddressInfoWrapper(BinaryKey addressPK, String line1, String line2, String line3, String code, Integer addressType) {
        this.addressInfo = new AddressInfo(addressPK.toString(), line1, line2, line3, code);
        this.addressType = AddressType.valueOf(addressType);
    }
}
