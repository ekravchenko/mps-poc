package org.testingzone.dbo.contact.query;

import org.testingzone.vo.contact.AllTelephonesInfo;
import org.testingzone.vo.contact.TelephoneInfo;
import org.testingzone.vo.contact.TelephoneType;

import java.util.List;

public final class AllTelephoneInfoWrapper {

    private final AllTelephonesInfo allTelephonesInfo;

    public AllTelephoneInfoWrapper(List<ContactTelephoneInfo> telephones) {
        TelephoneInfo cell = TelephoneInfo.EMPTY;
        TelephoneInfo fax = TelephoneInfo.EMPTY;
        TelephoneInfo home = TelephoneInfo.EMPTY;
        TelephoneInfo office = TelephoneInfo.EMPTY;

        for(ContactTelephoneInfo contactTelephoneInfo : telephones) {
            TelephoneType type = contactTelephoneInfo.getType();
            if (type == TelephoneType.FAX) {
                fax = contactTelephoneInfo.getTelephoneInfo();
            } else if (type == TelephoneType.HOME) {
                home = contactTelephoneInfo.getTelephoneInfo();
            } else if (type == TelephoneType.MOBILE) {
                cell = contactTelephoneInfo.getTelephoneInfo();
            } else if (type == TelephoneType.OFFICE) {
                office = contactTelephoneInfo.getTelephoneInfo();
            }
        }

        this.allTelephonesInfo = new AllTelephonesInfo(cell, office, fax, home);
    }

    public AllTelephonesInfo getAllTelephonesInfo() {
        return allTelephonesInfo;
    }
}
