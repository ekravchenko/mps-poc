package org.testingzone.dbl.contact.data;

public enum AddressType {

    PHYSICAL(2),
    POSTAL(1);

    private final int id;

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
