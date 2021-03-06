package org.testingzone.vo.person;

import java.util.Objects;

public enum Title {
    DR(1, "Dr"),
    MISS(2, "Miss"),
    MR(3, "Mr"),
    MRS(4, "Mrs"),
    MS(5, "Ms"),
    PROF(6, "Prof"),
    SIR(7, "Sir"),
    SISTER(8, "Sister"),
    UNKNOWN(99, "Unknown");

    private final int id;
    private final String title;

    Title(int id, String title) {
        this.title = title;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public static Title valueOf(Integer id) {
        for (Title title : Title.values()) {
            if (Objects.equals(id, title.id)) {
                return title;
            }
        }
        return Title.UNKNOWN;
    }
}
