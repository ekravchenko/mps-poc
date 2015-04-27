package org.testingzone.dbo.contact.query;

import com.mysema.query.annotations.QueryProjection;
import org.testingzone.dbo.base.AbstractInfoWrapper;
import org.testingzone.dbo.base.BinaryKey;
import org.testingzone.vo.contact.TelephoneInfo;

public class TelephoneInfoWrapper extends AbstractInfoWrapper<TelephoneInfo> {

    private TelephoneInfo telephoneInfo;

    @QueryProjection
    public TelephoneInfoWrapper(BinaryKey telephoneId, String number) {
        this.telephoneInfo = new TelephoneInfo(telephoneId.toString(), number);
    }

    @Override
    public TelephoneInfo get() {
        return telephoneInfo;
    }
}
