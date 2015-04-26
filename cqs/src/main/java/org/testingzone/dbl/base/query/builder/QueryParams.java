package org.testingzone.dbl.base.query.builder;

import org.testingzone.dbl.base.query.builder.join.JoinRequest;
import org.testingzone.vo.base.PageFilter;

import java.util.ArrayList;
import java.util.List;

public final class QueryParams<Filter> {

    private final Filter filter;

    private final PageFilter pageFilter;

    private final List<JoinRequest> joinRequests;

    public QueryParams() {
        this(null, PageFilter.NONE, new ArrayList<JoinRequest>());
    }

    public QueryParams(Filter filter, PageFilter pageFilter, List<JoinRequest> joinRequests) {
        this.filter = filter;
        this.pageFilter = pageFilter;
        this.joinRequests = joinRequests;
    }

    public QueryParams<Filter> filter(Filter filter) {
        return new QueryParams<>(filter, this.pageFilter, this.joinRequests);
    }

    public QueryParams<Filter> page(PageFilter pageFilter) {
        return new QueryParams<>(this.filter, pageFilter, this.joinRequests);
    }

    public QueryParams<Filter> joins(List<JoinRequest> joins) {
        return new QueryParams<>(this.filter, this.pageFilter, joins);
    }

    public Filter getFilter() {
        return filter;
    }

    public PageFilter getPageFilter() {
        return pageFilter;
    }

    public List<JoinRequest> getJoinRequests() {
        return joinRequests;
    }
}
