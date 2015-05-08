package org.testingzone.service;

public final class BaseConstants {

    private BaseConstants() {
    }

    public static class Uri {
        private Uri() {
        }

        public final static String CONTEXT_ROOT = "/mps/api/v2";
        public static final String BUSINESS = "/business/{" + BaseConstants.Path.BUSINESS_ID + "}";
    }

    public static class Path {
        private Path() {
        }

        public static final String BUSINESS_ID = "businessId";
    }


    public static class Query {
        private Query() {
        }

        public static final String SEARCH = "search";
        public static final String PAGE_INDEX = "pageIndex";
        public static final String ITEMS_PER_PAGE = "itemsPerPage";
        public static final String SORT_PROPERTY = "sort";
        public static final String SORT_ORDER = "order";
    }
}
