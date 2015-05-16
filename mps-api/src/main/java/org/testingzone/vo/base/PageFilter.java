package org.testingzone.vo.base;

public class PageFilter {

    public static final PageFilter NONE = new PageFilter(0, 0);

    private final int pageIndex;

    private final int itemsPerPage;

    private PageFilter(int pageIndex, int itemsPerPage) {
        this.pageIndex = pageIndex;
        this.itemsPerPage = itemsPerPage;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public int getItemsPerPage() {
        return itemsPerPage;
    }

    public static PageFilter create(Integer pageIndex, Integer itemsPerPage) {
        if (pageIndex == null || itemsPerPage == null) {
            return PageFilter.NONE;
        }
        return new PageFilter(pageIndex, itemsPerPage);
    }
}
