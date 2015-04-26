package org.testingzone.dbl.base.query.builder;

import com.mysema.query.types.EntityPath;

public interface QueryProvider<Filter> {

    Query createQuery(Filter filter);

    EntityPath getQueryRoot();
}
