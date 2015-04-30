package org.testingzone.dbo.contact.query;

import com.mysema.query.annotations.QueryProjection;
import lombok.Getter;
import org.testingzone.dbl.contact.data.TelephoneInfo;
import org.testingzone.dbl.contact.data.TelephoneType;
import org.testingzone.dbo.base.BinaryKey;

@Getter
public class TelephoneInfoWrapper {

    private TelephoneInfo telephoneInfo;

    private TelephoneType telephoneType;

    @QueryProjection
    public TelephoneInfoWrapper(BinaryKey telephoneId, String number, Integer type) {
        this.telephoneInfo = new TelephoneInfo(telephoneId.toString(), number);
        this.telephoneType = TelephoneType.valueOf(type);
    }
}
