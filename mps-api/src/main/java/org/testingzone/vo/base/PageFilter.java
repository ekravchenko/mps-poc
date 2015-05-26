package org.testingzone.vo.base;

import com.google.gwt.user.client.rpc.IsSerializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageFilter implements IsSerializable {

    public static final PageFilter NONE = new PageFilter(0, 0);

    private int pageIndex;
    private int itemsPerPage;

    public static PageFilter create(Integer pageIndex, Integer itemsPerPage) {
        if (pageIndex == null || itemsPerPage == null) {
            return PageFilter.NONE;
        }
        return new PageFilter(pageIndex, itemsPerPage);
    }
}
