package org.testingzone.vo.base;

import lombok.Value;

@Value
public final class PageFilter {

    public static final PageFilter NONE = new PageFilter(0, 0);

    private final int pageIndex;
    private final int itemsPerPage;

    public static PageFilter create(Integer pageIndex, Integer itemsPerPage) {
        if (pageIndex == null || itemsPerPage == null) {
            return PageFilter.NONE;
        }
        return new PageFilter(pageIndex, itemsPerPage);
    }
}
