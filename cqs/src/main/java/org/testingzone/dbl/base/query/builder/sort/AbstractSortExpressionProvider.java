package org.testingzone.dbl.base.query.builder.sort;

import com.mysema.query.types.Expression;
import org.testingzone.vo.base.SortFilter;

import java.util.Map;

public abstract class AbstractSortExpressionProvider implements SortExpressionProvider {

    @Override
    public SortExpression build(SortFilter sortFilter) {
        if (sortFilter == null) {
            return SortExpression.NONE;
        }
        Map<String, Expression> expressionMap = getExpressionMap();
        Expression expression = expressionMap.get(sortFilter.getSortProperty());
        return new SortExpression(expression, sortFilter.getSortOrder());
    }

    protected abstract Map<String, Expression> getExpressionMap();
}
