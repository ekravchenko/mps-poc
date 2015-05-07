package org.testingzone.dbl.contact.data;


public enum TelephoneType {

    HOME(2), FAX(4), OFFICE(1), MOBILE(3);

    private final int id;

    TelephoneType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static TelephoneType valueOf(Integer id) {
        for (TelephoneType telephoneType : values()) {
            if (Integer.valueOf(telephoneType.id).equals(id)) {
                return telephoneType;
            }
        }
        return null;
    }
}
