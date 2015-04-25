package org.testingzone.dbl.base.query.builder;

import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.EntityPath;
import org.testingzone.dbl.base.query.builder.join.JoinRequest;
import org.testingzone.vo.base.PageFilter;

import javax.persistence.EntityManager;

public abstract class AbstractQueryBuilder<Filter> implements QueryBuilder<Filter> {

    protected final EntityManager entityManager;

    protected AbstractQueryBuilder(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    protected abstract Query createQuery(Filter filter);

    protected abstract EntityPath getQueryRoot();

    @Override
    public JPAQuery buildQuery(Filter filter) {
        return buildQuery(filter, PageFilter.NONE);
    }

    @Override
    public JPAQuery buildQuery(Filter filter, PageFilter pageFilter) {
        JPAQuery jpaQuery = new JPAQuery(entityManager);
        Query query = createQuery(filter);
        jpaQuery = jpaQuery.from(getQueryRoot());
        jpaQuery = applyJoins(jpaQuery, query);
        jpaQuery = applyWhere(jpaQuery, query, pageFilter);
        return jpaQuery;
    }

    private JPAQuery applyJoins(JPAQuery jpaQuery, Query query) {
        for (JoinRequest joinRequest : query.getJoins()) {
            jpaQuery = joinRequest.applyJoin(jpaQuery);
        }
        return jpaQuery;
    }

    private JPAQuery applyWhere(JPAQuery jpaQuery, Query query, PageFilter pageFilter) {
        jpaQuery = jpaQuery.where(query.getWhereClause());
        jpaQuery = applyPagination(jpaQuery, pageFilter);
        return jpaQuery;
    }

    private JPAQuery applyPagination(JPAQuery jpaQuery, PageFilter filterVO) {
        if (filterVO.getItemsPerPage() > 0) {
            jpaQuery = jpaQuery.offset(filterVO.getPageIndex() * filterVO.getItemsPerPage());
            jpaQuery = jpaQuery.limit(filterVO.getItemsPerPage());
        }
        return jpaQuery;
    }
}
