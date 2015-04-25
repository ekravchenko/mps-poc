package org.testingzone.vo.base;

public class SimpleFilter {

    public static final SimpleFilter EMPTY = new SimpleFilter(null, null);

    private final String businessPK;

    private final String text;

    public SimpleFilter(String businessPK, String text) {
        this.businessPK = businessPK;
        this.text = text;
    }

    public String getBusinessPK() {
        return businessPK;
    }

    public String getText() {
        return text;
    }
}
