package org.testingzone.vo.doctor;

public class SimpleFilter {

    public static final SimpleFilter EMPTY = new SimpleFilter(null, null);

    private final byte[] businessPK;

    private final String text;

    public SimpleFilter(byte[] businessPK, String text) {
        this.businessPK = businessPK;
        this.text = text;
    }

    public byte[] getBusinessPK() {
        return businessPK;
    }

    public String getText() {
        return text;
    }
}
