package org.testingzone.vo.base;

import com.google.gwt.user.client.rpc.IsSerializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimpleFilter implements IsSerializable {

    public static final SimpleFilter EMPTY = new SimpleFilter(null, null);

    private String businessPK;
    private String text;
}
