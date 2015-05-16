package org.testingzone.vo.doctor;

public enum DoctorSortProperty {

    NAME("name");

    private final String s;

    DoctorSortProperty(String str) {
        this.s = str;
    }

    @Override
    public String toString() {
        return s;
    }
}
