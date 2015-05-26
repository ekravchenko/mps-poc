package org.testingzone.vo.base;

import com.google.gwt.user.client.rpc.IsSerializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SortFilter implements IsSerializable {

    public final static SortFilter NONE = new SortFilter(null, null);

    private String sortProperty;
    private SortOrder sortOrder;

    public static SortFilter create(String sortProperty, SortOrder sortOrder) {
        if (sortProperty == null || sortOrder == null) {
            return SortFilter.NONE;
        }
        return new SortFilter(sortProperty, sortOrder);
    }
}
