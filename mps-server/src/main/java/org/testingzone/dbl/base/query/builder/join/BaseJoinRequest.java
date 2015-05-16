package org.testingzone.dbl.base.query.builder.join;

import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.*;

/**
 * The base class for all join requests
 */
public abstract class BaseJoinRequest implements JoinRequest {

    /**
     * The actual join path
     */
    private final Expression target;

    /**
     * Alias that is used further in a query
     */
    private final Path alias;

    /**
     * Create a join request based on provided path and alias
     *
     * @param target - the actual join. Path that should be used for join. It could be collection or single entity join.
     *               Shouldn't be null
     * @param alias  - Alias that will be further used in 'where' clause
     */
    BaseJoinRequest(Expression target, Path alias) {
        this.target = target;
        this.alias = alias;
    }

    @Override
    public JPAQuery applyJoin(JPAQuery jpaQuery) {
        if (target instanceof EntityPath) {
            return applyJoin(jpaQuery, (EntityPath) target, alias);
        } else if (target instanceof CollectionExpression) {
            return applyJoin(jpaQuery, (CollectionExpression) target, alias);
        } else if (target instanceof MapExpression) {
            return applyJoin(jpaQuery, (MapExpression) target, alias);
        }
        return jpaQuery;
    }

    protected abstract JPAQuery applyJoin(JPAQuery jpaQuery, EntityPath target, Path alias);

    protected abstract JPAQuery applyJoin(JPAQuery jpaQuery, CollectionExpression target, Path alias);

    protected abstract JPAQuery applyJoin(JPAQuery jpaQuery, MapExpression target, Path alias);
}
