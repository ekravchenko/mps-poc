package org.testingzone.dbl.base.query.builder;

import org.testingzone.dbl.base.query.builder.join.JoinRequest;
import org.testingzone.dbl.base.query.builder.sort.SortExpression;
import org.testingzone.vo.base.PageFilter;

import java.util.ArrayList;
import java.util.List;

public final class QueryParams<Filter> {

    private final Filter filter;

    private final PageFilter pageFilter;

    private final SortExpression sortExpression;

    private final List<JoinRequest> joinRequests;

    public QueryParams() {
        this(null, new ArrayList<JoinRequest>(), PageFilter.NONE, SortExpression.NONE);
    }

    public QueryParams(Filter filter, List<JoinRequest> joinRequests, PageFilter pageFilter, SortExpression sortExpression) {
        this.filter = filter;
        this.pageFilter = pageFilter;
        this.joinRequests = joinRequests;
        this.sortExpression = sortExpression;
    }

    public QueryParams<Filter> filter(Filter filter) {
        return new QueryParams<>(filter, this.joinRequests, this.pageFilter, this.sortExpression);
    }

    public QueryParams<Filter> page(PageFilter pageFilter) {
        return new QueryParams<>(this.filter, this.joinRequests, pageFilter, this.sortExpression);
    }

    public QueryParams<Filter> joins(List<JoinRequest> joins) {
        return new QueryParams<>(this.filter, joins, this.pageFilter, this.sortExpression);
    }

    public QueryParams<Filter> sort(SortExpression sortExpression) {
        return new QueryParams<>(this.filter, this.joinRequests, this.pageFilter, sortExpression);
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

    public SortExpression getSortExpression() {
        return sortExpression;
    }
}
