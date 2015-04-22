package org.testingzone.service;

import org.testingzone.vo.doctor.DoctorSummaryInfo;
import org.testingzone.vo.doctor.SimpleFilter;

import java.util.List;

public interface DoctorService {

    long count(SimpleFilter filter);

    List<DoctorSummaryInfo> getDoctorSummaries(SimpleFilter filter);
}
