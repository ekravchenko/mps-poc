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

        public static final String DOCTORS = BaseConstants.Uri.BUSINESS + "/doctors";
        public static final String DOCTORS_PAGE = DOCTORS + "/page";
        public static final String DOCTOR_DETAILS = DOCTORS + "/{" + Path.DOCTOR_ID + "}";
    }
}
