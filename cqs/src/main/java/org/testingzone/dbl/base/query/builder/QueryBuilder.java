package org.testingzone.dbl.base.query.builder;

import com.mysema.query.jpa.impl.JPAQuery;
import org.testingzone.vo.base.PageFilter;

/**
 * Interface that defines API that every query builder should expose
 */
public interface QueryBuilder<Filter> {

    JPAQuery buildQuery(Filter filter);

    JPAQuery buildQuery(Filter filter, PageFilter pageFilter);
}
