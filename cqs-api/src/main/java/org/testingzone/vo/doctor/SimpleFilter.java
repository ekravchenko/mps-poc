package org.testingzone.vo.doctor;

public class SimpleFilter {

    public static final SimpleFilter EMPTY = new SimpleFilter(null, null);

    private  String businessPK;

    private  String text;

    public SimpleFilter(String businessPK, String text) {
        this.businessPK = businessPK;
        this.text = text;
    }

    public SimpleFilter() {
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setBusinessPK(String businessPK) {
        this.businessPK = businessPK;
    }

    public String getText() {
        return text;
    }

    public String getBusinessPK() {
        return businessPK;
    }
}
