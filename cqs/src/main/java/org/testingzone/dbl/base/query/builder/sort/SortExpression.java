package org.testingzone.dbl.base.query.builder.sort;

import com.mysema.query.types.Expression;
import com.mysema.query.types.Order;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public final class SortExpression {

    public static final SortExpression NONE = new SortExpression(null, null);

    private final Expression expression;

    private final Order sortOrder;

    public SortExpression(Expression expression, Order sortOrder) {
        this.expression = expression;
        this.sortOrder = sortOrder;
    }
}
