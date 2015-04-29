package org.testingzone.service.doctor;

import org.testingzone.service.BaseConstants;

public final class DoctorConstants {

    private DoctorConstants() {
    }

    public static class Path {
        private Path() {
        }

        public static final String DOCTOR_ID = "id";
    }

    public static class Uri {
        private Uri() {
        }

        public static final String DOCTORS = "/business/{" + BaseConstants.Path.BUSINESS_ID + "}/doctors";
        public static final String DOCTORS_PAGE = DOCTORS + "/page";
        public static final String DOCTOR_DETAILS = "/doctors/{" + Path.DOCTOR_ID + "}";
    }
}
