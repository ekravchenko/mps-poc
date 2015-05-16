package org.testingzone.dbl.base.query.builder;

import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.OrderSpecifier;
import org.testingzone.dbl.base.query.builder.join.JoinRequest;
import org.testingzone.dbl.base.query.builder.sort.SortExpression;
import org.testingzone.vo.base.PageFilter;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class QueryBuilder<Filter> {

    private final EntityManager entityManager;

    private final QueryProvider<Filter> queryProvider;

    private final QueryParams<Filter> queryParams;

    public QueryBuilder(EntityManager entityManager, QueryProvider<Filter> queryProvider) {
        this(entityManager, queryProvider, new QueryParams<>());
    }

    private QueryBuilder(EntityManager entityManager, QueryProvider<Filter> queryProvider, QueryParams<Filter> queryParams) {
        this.entityManager = entityManager;
        this.queryProvider = queryProvider;
        this.queryParams = queryParams;
    }

    public QueryBuilder<Filter> filter(Filter filter) {
        QueryParams<Filter> queryParams = this.queryParams.filter(filter);
        return new QueryBuilder<>(entityManager, queryProvider, queryParams);
    }

    public QueryBuilder<Filter> page(PageFilter pageFilter) {
        QueryParams<Filter> queryParams = this.queryParams.page(pageFilter);
        return new QueryBuilder<>(entityManager, queryProvider, queryParams);
    }

    public QueryBuilder<Filter> joins(JoinRequest... joins) {
        List<JoinRequest> joinsList = (joins != null) ? Arrays.asList(joins) : new ArrayList<>();
        return joins(joinsList);
    }

    private QueryBuilder<Filter> joins(List<JoinRequest> joins) {
        QueryParams<Filter> queryParams = this.queryParams.joins(joins);
        return new QueryBuilder<>(entityManager, queryProvider, queryParams);
    }

    public QueryBuilder<Filter> sort(SortExpression sortExpression) {
        QueryParams<Filter> queryParams = this.queryParams.sort(sortExpression);
        return new QueryBuilder<>(entityManager, queryProvider, queryParams);
    }

    public JPAQuery build() {
        JPAQuery jpaQuery = new JPAQuery(entityManager);
        jpaQuery = jpaQuery.from(queryProvider.getQueryRoot());
        Query query = Query.EMPTY;
        if (queryParams.getFilter() != null) {
            query = queryProvider.createQuery(queryParams.getFilter());
        }
        if (queryParams.getJoinRequests() != null) {
            query = query.join(queryParams.getJoinRequests());
        }
        jpaQuery = applyJoins(jpaQuery, query);
        jpaQuery = applyWhere(jpaQuery, query);

        if (queryParams.getPageFilter() != null) {
            jpaQuery = applyPagination(jpaQuery, queryParams.getPageFilter());
        }
        if (queryParams.getSortExpression() != null) {
            jpaQuery = applySorting(jpaQuery, queryParams.getSortExpression());
        }
        return jpaQuery;
    }

    private JPAQuery applyJoins(JPAQuery jpaQuery, Query query) {
        for (JoinRequest joinRequest : query.getJoins()) {
            jpaQuery = joinRequest.applyJoin(jpaQuery);
        }
        return jpaQuery;
    }

    private JPAQuery applyWhere(JPAQuery jpaQuery, Query query) {
        jpaQuery = jpaQuery.where(query.getWhereClause());
        return jpaQuery;
    }

    private JPAQuery applyPagination(JPAQuery jpaQuery, PageFilter pageFilter) {
        if (pageFilter.getItemsPerPage() > 0) {
            jpaQuery = jpaQuery.offset(pageFilter.getPageIndex() * pageFilter.getItemsPerPage());
            jpaQuery = jpaQuery.limit(pageFilter.getItemsPerPage());
        }
        return jpaQuery;
    }

    @SuppressWarnings("unchecked")
    private JPAQuery applySorting(JPAQuery jpaQuery, SortExpression sortExpression) {
        if (sortExpression.getExpression() != null) {
            OrderSpecifier orderSpecifier = new OrderSpecifier(sortExpression.getSortOrder(), sortExpression.getExpression());
            jpaQuery.orderBy(orderSpecifier);
        }
        return jpaQuery;
    }
}
