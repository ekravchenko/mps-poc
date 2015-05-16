package org.testingzone.vo.base;

public enum SortOrder {

    ASC, DESC;

    public static SortOrder from(String order) {
        if (order == null) {
            return SortOrder.ASC;
        }
        return SortOrder.valueOf(order);
    }
}
