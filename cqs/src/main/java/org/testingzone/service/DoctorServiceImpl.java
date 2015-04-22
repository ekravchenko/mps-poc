package org.testingzone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.testingzone.dbl.doctor.query.DoctorSummaryQuery;
import org.testingzone.vo.doctor.DoctorSummaryInfo;
import org.testingzone.vo.doctor.SimpleFilter;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorSummaryQuery doctorSummaryQuery;

    public long count(SimpleFilter filter) {
        return doctorSummaryQuery.count(filter);
    }

    public List<DoctorSummaryInfo> getDoctorSummaries(SimpleFilter filter) {
        return doctorSummaryQuery.getDoctorSummaries(filter);
    }
}
