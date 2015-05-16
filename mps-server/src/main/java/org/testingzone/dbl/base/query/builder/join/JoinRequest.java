package org.testingzone.dbl.base.query.builder.join;

import com.mysema.query.jpa.impl.JPAQuery;

/**
 * Interface that defines the basic API to perform joins
 */
public interface JoinRequest {

    /**
     * Apply join to JPAQuery object
     *
     * @param jpaQuery - JPAQuery to apply join to. Should never be null
     * @return JPAQuery with join
     */
    JPAQuery applyJoin(JPAQuery jpaQuery);
}
