package org.testingzone.dbl.contact.query.helpers;

import org.testingzone.vo.contact.query.TelephoneInfo;

public final class AllTelephonesInfo {

    public static final AllTelephonesInfo EMPTY =
            new AllTelephonesInfo(TelephoneInfo.EMPTY, TelephoneInfo.EMPTY, TelephoneInfo.EMPTY, TelephoneInfo.EMPTY);

    private final TelephoneInfo cellphone;

    private final TelephoneInfo office;

    private final TelephoneInfo fax;

    private final TelephoneInfo home;

    public AllTelephonesInfo(TelephoneInfo cellphone, TelephoneInfo office, TelephoneInfo fax, TelephoneInfo home) {
        this.cellphone = cellphone;
        this.office = office;
        this.fax = fax;
        this.home = home;
    }

    public TelephoneInfo getCellphone() {
        return cellphone;
    }

    public TelephoneInfo getOffice() {
        return office;
    }

    public TelephoneInfo getFax() {
        return fax;
    }

    public TelephoneInfo getHome() {
        return home;
    }
}
