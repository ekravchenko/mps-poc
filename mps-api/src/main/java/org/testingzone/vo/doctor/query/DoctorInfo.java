package org.testingzone.vo.doctor.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.testingzone.vo.person.Title;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class DoctorInfo {

    private String doctorPK;
    private String personPK;
    private String contactPK;
    private String name;
    private String surname;
    private Title title;
    private String speciality;
    private String billingNumber;
    private String treatingNumber;
}
