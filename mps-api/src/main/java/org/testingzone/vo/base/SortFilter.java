package org.testingzone.vo.base;

import lombok.Value;

@Value
public final class SortFilter {

    public final static SortFilter NONE = new SortFilter(null, null);

    private final String sortProperty;
    private final SortOrder sortOrder;

    public static SortFilter create(String sortProperty, SortOrder sortOrder) {
        if (sortProperty == null || sortOrder == null) {
            return SortFilter.NONE;
        }
        return new SortFilter(sortProperty, sortOrder);
    }
}
