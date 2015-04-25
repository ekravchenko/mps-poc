package org.testingzone.vo.base;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class SimpleFilter {

    public static final SimpleFilter EMPTY = new SimpleFilter(null, null);

    private final String businessPK;

    private final String text;

    public SimpleFilter(String businessPK, String text) {
        this.businessPK = businessPK;
        this.text = text;
    }
}
