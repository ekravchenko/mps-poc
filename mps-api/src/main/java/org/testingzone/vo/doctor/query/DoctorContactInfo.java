package org.testingzone.vo.doctor.query;

import com.google.gwt.user.client.rpc.IsSerializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class DoctorContactInfo implements IsSerializable {

    public static final DoctorContactInfo EMPTY = new DoctorContactInfo(null, null, null, null, null, null);

    private String contactPK;
    private String cellTelephone;
    private String faxTelephone;
    private String homeTelephone;
    private String officeTelephone;
    private String email;
}
