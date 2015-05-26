package org.testingzone.vo.base;

import com.google.gwt.user.client.rpc.IsSerializable;

public enum SortOrder implements IsSerializable {

    ASC, DESC;

    public static SortOrder from(String order) {
        if (order == null) {
            return SortOrder.ASC;
        }
        return SortOrder.valueOf(order);
    }
}
