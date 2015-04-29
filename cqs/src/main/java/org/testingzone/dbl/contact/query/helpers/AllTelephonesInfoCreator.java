package org.testingzone.dbl.contact.query.helpers;

import org.testingzone.dbo.contact.query.TelephoneInfoWrapper;
import org.testingzone.vo.contact.query.TelephoneInfo;
import org.testingzone.vo.contact.TelephoneType;

import java.util.List;

public final class AllTelephonesInfoCreator {

    private final AllTelephonesInfo allTelephonesInfo;

    public AllTelephonesInfoCreator(List<TelephoneInfoWrapper> telephones) {
        TelephoneInfo cell = TelephoneInfo.EMPTY;
        TelephoneInfo fax = TelephoneInfo.EMPTY;
        TelephoneInfo home = TelephoneInfo.EMPTY;
        TelephoneInfo office = TelephoneInfo.EMPTY;

        for (TelephoneInfoWrapper telephoneInfoWrapper : telephones) {
            TelephoneType type = telephoneInfoWrapper.getTelephoneType();
            if (type == TelephoneType.FAX) {
                fax = telephoneInfoWrapper.getTelephoneInfo();
            } else if (type == TelephoneType.HOME) {
                home = telephoneInfoWrapper.getTelephoneInfo();
            } else if (type == TelephoneType.MOBILE) {
                cell = telephoneInfoWrapper.getTelephoneInfo();
            } else if (type == TelephoneType.OFFICE) {
                office = telephoneInfoWrapper.getTelephoneInfo();
            }
        }

        this.allTelephonesInfo = new AllTelephonesInfo(cell, office, fax, home);
    }

    public AllTelephonesInfo getAllTelephonesInfo() {
        return allTelephonesInfo;
    }
}
