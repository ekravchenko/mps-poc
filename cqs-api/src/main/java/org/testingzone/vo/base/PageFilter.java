package org.testingzone.vo.base;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class PageFilter {

    public static PageFilter NONE = new PageFilter(0, 0);

    private final int pageIndex;

    private final int itemsPerPage;

    public PageFilter(int pageIndex, int itemsPerPage) {
        this.pageIndex = pageIndex;
        this.itemsPerPage = itemsPerPage;
    }
}
