package org.testingzone.dbl.base.query.builder.sort;

import org.testingzone.vo.base.SortFilter;

interface SortExpressionProvider {

    SortExpression build(SortFilter sortFilter);
}
