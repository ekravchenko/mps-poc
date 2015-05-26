package org.testingzone.vo.base;

import com.google.gwt.user.client.rpc.IsSerializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class SummaryPageInfo<T> implements IsSerializable {

    private long totalCount;
    private List<T> items;
}
