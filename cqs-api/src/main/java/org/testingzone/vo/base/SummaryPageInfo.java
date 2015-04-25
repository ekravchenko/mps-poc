package org.testingzone.vo.base;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class SummaryPageInfo<T> {

    private long totalCount;

    private List<T> items;

    public SummaryPageInfo(long totalCount) {
        this(totalCount, new ArrayList<T>());
    }

    public SummaryPageInfo(long totalCount, List<T> items) {
        this.totalCount = totalCount;
        this.items = items;
    }
}
