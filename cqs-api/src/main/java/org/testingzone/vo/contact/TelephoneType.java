package org.testingzone.vo.contact;


public enum TelephoneType {

    HOME(1, "Home"), FAX(2, "Fax"), OFFICE(3, "Office"), MOBILE(4, "Mobile");

    private int id;

    private String desc;

    TelephoneType(int id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public static TelephoneType valueOf(Integer id) {
        for(TelephoneType telephoneType : values()) {
            if(Integer.valueOf(telephoneType.id).equals(id)) {
                return telephoneType;
            }
        }
        return null;
    }
}
