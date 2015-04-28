package org.testingzone.service.doctor;

public final class DoctorServicePath {

    private DoctorServicePath() {
    }

    public static final String DOCTORS = "/doctors";

    public static final String DOCTORS_PAGE = "/page";

    public static final String DOCTORS_PAGE_INITIAL = "/page/initial";

    public static final String DOCTOR_ID = "id";

    public static final String DOCTOR_DETAILS = "/{" + DOCTOR_ID + "}";
}
