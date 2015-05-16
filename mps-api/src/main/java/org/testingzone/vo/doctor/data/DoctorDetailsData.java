package org.testingzone.vo.doctor.data;


import org.testingzone.vo.contact.data.ContactData;

import java.util.ArrayList;
import java.util.List;

public class DoctorDetailsData {
    public DoctorData doctorData;
    public ContactData contactData;
    public List<DoctorNetworkData> doctorNetworkDataList = new ArrayList<>();
}
