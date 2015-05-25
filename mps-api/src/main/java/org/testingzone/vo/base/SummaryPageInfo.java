package org.testingzone.vo.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class SummaryPageInfo<T> implements Serializable {

    private long totalCount;
    private List<T> items;
}
