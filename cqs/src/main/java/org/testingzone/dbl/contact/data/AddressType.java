package org.testingzone.dbl.contact.data;

import com.google.common.base.Objects;

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
            if (Objects.equal(id, addressType.id)) {
                return addressType;
            }
        }
        throw new IllegalArgumentException(String.format("Unknown AddressType id %s", id));
    }
}
