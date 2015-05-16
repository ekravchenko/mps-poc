package org.testingzone.vo.base;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class SummaryPageInfo<T> {

    @JsonProperty
    private final long totalCount;

    @JsonProperty
    private final List<T> items;

    public SummaryPageInfo(long totalCount) {
        this(totalCount, new ArrayList<>());
    }

    @JsonCreator
    public SummaryPageInfo(@JsonProperty("totalCount") long totalCount, @JsonProperty("items") List<T> items) {
        this.totalCount = totalCount;
        this.items = items;
    }

    public List<T> getItems() {
        return items;
    }

    public long getTotalCount() {
        return totalCount;
    }
}