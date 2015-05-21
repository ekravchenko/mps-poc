package org.testingzone.vo.base;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.util.List;

@Value
public final class SummaryPageInfo<T> {

    @JsonProperty
    private final long totalCount;
    @JsonProperty
    private final List<T> items;

    @JsonCreator
    public SummaryPageInfo(@JsonProperty("totalCount") long totalCount, @JsonProperty("items") List<T> items) {
        this.totalCount = totalCount;
        this.items = items;
    }
}
