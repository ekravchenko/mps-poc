package org.testingzone.vo.base;

public class PageFilter {

    public static PageFilter NONE = new PageFilter(0, 0);

    private final int pageIndex;

    private final int itemsPerPage;

    public PageFilter(int pageIndex, int itemsPerPage) {
        this.pageIndex = pageIndex;
        this.itemsPerPage = itemsPerPage;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public int getItemsPerPage() {
        return itemsPerPage;
    }
}
