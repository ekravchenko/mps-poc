package org.testingzone.vo.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimpleFilter {

    public static final SimpleFilter EMPTY = new SimpleFilter(null, null);

    private String businessPK;
    private String text;
}
