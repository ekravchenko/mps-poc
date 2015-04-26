package org.testingzone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.testingzone.dbl.doctor.query.DoctorSummaryQuery;
import org.testingzone.service.doctor.DoctorService;
import org.testingzone.vo.base.PageFilter;
import org.testingzone.vo.base.SimpleFilter;
import org.testingzone.vo.base.SortFilter;
import org.testingzone.vo.base.SummaryPageInfo;
import org.testingzone.vo.doctor.DoctorSummaryInfo;

import java.util.List;


@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorSummaryQuery doctorSummaryQuery;

    @Override
    public SummaryPageInfo<DoctorSummaryInfo> getDoctorSummaryPageInfo(SimpleFilter filter, PageFilter pageFilter, SortFilter sortFilter) {
        return doctorSummaryQuery.getSummaryPageInfo(filter, pageFilter, sortFilter);
    }

    @Override
    public List<DoctorSummaryInfo> getDoctorSummaries(SimpleFilter filter, PageFilter pageFilter, SortFilter sortFilter) {
        return doctorSummaryQuery.getSummaryInfoList(filter, pageFilter, sortFilter);
    }
}
