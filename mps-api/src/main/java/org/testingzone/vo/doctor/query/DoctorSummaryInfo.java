package org.testingzone.vo.doctor.query;

import com.google.gwt.user.client.rpc.IsSerializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class DoctorSummaryInfo implements IsSerializable {

    private String id;
    private String fullName;
    private String billingPracticeNumber;
    private String practiceName;
    private String speciality;
}
