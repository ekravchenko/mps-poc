package org.testingzone.dbl.base.query.builder.join;


import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.*;

/**
 * Implementation of JoinRequest interface that provides <b>left join</b> functionality
 */
public class LeftJoinRequest extends BaseJoinRequest {

    public LeftJoinRequest(Expression target, Path alias) {
        super(target, alias);
    }

    @Override
    protected JPAQuery applyJoin(JPAQuery jpaQuery, EntityPath target, Path alias) {
        return jpaQuery.leftJoin(target, alias);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected JPAQuery applyJoin(JPAQuery jpaQuery, CollectionExpression target, Path alias) {
        return jpaQuery.leftJoin(target, alias);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected JPAQuery applyJoin(JPAQuery jpaQuery, MapExpression target, Path alias) {
        return jpaQuery.leftJoin(target, alias);
    }
}
