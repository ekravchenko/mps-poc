package org.testingzone.vo.base;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class SummaryPageInfo<T> {

    @JsonProperty
    private long totalCount;

    @JsonProperty
    private List<T> items;

    @JsonCreator
    public SummaryPageInfo(@JsonProperty("totalCount") long totalCount) {
        this(totalCount, new ArrayList<T>());
    }

    @JsonCreator
    public SummaryPageInfo(@JsonProperty("totalCount") long totalCount, @JsonProperty("list") List<T> items) {
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
