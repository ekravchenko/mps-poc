package org.testingzone.dbo.contact.query;

import com.mysema.query.annotations.QueryProjection;
import lombok.Getter;
import org.testingzone.dbo.base.BinaryKey;
import org.testingzone.vo.contact.TelephoneInfo;
import org.testingzone.vo.contact.TelephoneType;

public final class ContactTelephoneInfo {

    private final String telephonePK;

    private final String number;

    private final TelephoneType type;

    @QueryProjection
    public ContactTelephoneInfo(BinaryKey telephonePK, String number, Integer type) {
        this.telephonePK = telephonePK.toString();
        this.number = number;
        this.type = TelephoneType.valueOf(type);
    }

    public TelephoneType getType() {
        return type;
    }

    public TelephoneInfo getTelephoneInfo() {
        return new TelephoneInfo(telephonePK, number);
    }
}
