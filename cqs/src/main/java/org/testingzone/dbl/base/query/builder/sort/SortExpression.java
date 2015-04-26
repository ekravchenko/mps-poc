package org.testingzone.dbl.base.query.builder.sort;

import com.mysema.query.types.Expression;
import lombok.Getter;
import lombok.ToString;
import org.testingzone.vo.base.SortOrder;

@Getter
@ToString
public final class SortExpression {

    public static final SortExpression NONE = new SortExpression(null, null);

    private final Expression expression;

    private final SortOrder sortOrder;

    public SortExpression(Expression expression, SortOrder sortOrder) {
        this.expression = expression;
        this.sortOrder = sortOrder;
    }
}
