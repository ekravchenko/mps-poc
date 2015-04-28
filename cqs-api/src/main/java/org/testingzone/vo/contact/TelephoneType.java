package org.testingzone.vo.contact;


public enum TelephoneType {

    HOME(1), FAX(2), OFFICE(3), MOBILE(4);

    private int id;

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
