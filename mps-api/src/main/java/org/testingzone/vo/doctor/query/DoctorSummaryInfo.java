package org.testingzone.vo.doctor.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class DoctorSummaryInfo implements Serializable {

    private String id;
    private String fullName;
    private String billingPracticeNumber;
    private String practiceName;
    private String speciality;
}
