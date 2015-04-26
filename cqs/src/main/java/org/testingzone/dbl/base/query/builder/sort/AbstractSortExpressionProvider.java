package org.testingzone.dbl.base.query.builder.sort;

import com.mysema.query.types.Expression;
import com.mysema.query.types.Order;
import org.testingzone.vo.base.SortFilter;
import org.testingzone.vo.base.SortOrder;

import java.util.Map;

public abstract class AbstractSortExpressionProvider implements SortExpressionProvider {

    @Override
    public SortExpression build(SortFilter sortFilter) {
        if (sortFilter == null) {
            return SortExpression.NONE;
        }
        Map<String, Expression> expressionMap = getExpressionMap();
        Expression expression = expressionMap.get(sortFilter.getSortProperty());
        Order order = SortOrder.ASC == sortFilter.getSortOrder() ? Order.ASC : Order.DESC;
        return new SortExpression(expression, order);
    }

    protected abstract Map<String, Expression> getExpressionMap();
}
