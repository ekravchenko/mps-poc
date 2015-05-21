package org.testingzone.vo.base;

import lombok.Value;

@Value
public final class SimpleFilter {

    public static final SimpleFilter EMPTY = new SimpleFilter(null, null);

    private final String businessPK;
    private final String text;
}
