package org.testingzone.vo.contact;

public enum AddressType {

    PHYSICAL(2),
    POSTAL(1);

    private int id;

    AddressType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static AddressType valueOf(Integer id) {
        for (AddressType addressType : values()) {
            if (Integer.valueOf(addressType.id).equals(id)) {
                return addressType;
            }
        }
        return null;
    }
}
