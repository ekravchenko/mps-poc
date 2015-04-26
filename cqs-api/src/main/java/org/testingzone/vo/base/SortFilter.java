package org.testingzone.vo.base;

public final class SortFilter {

    public final static SortFilter NONE = new SortFilter(null, null);

    private final String sortProperty;

    private final SortOrder sortOrder;

    public SortFilter(String sortProperty, SortOrder sortOrder) {
        this.sortProperty = sortProperty;
        this.sortOrder = sortOrder;
    }

    public String getSortProperty() {
        return sortProperty;
    }

    public SortOrder getSortOrder() {
        return sortOrder;
    }
}
