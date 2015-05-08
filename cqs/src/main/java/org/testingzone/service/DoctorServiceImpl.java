package org.testingzone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.testingzone.dbl.doctor.query.DoctorDetailsQuery;
import org.testingzone.dbl.doctor.query.DoctorSummaryQuery;
import org.testingzone.dbo.base.BinaryKey;
import org.testingzone.service.doctor.DoctorService;
import org.testingzone.vo.base.PageFilter;
import org.testingzone.vo.base.SimpleFilter;
import org.testingzone.vo.base.SortFilter;
import org.testingzone.vo.base.SummaryPageInfo;
import org.testingzone.vo.doctor.data.DoctorDetailsData;
import org.testingzone.vo.doctor.query.DoctorDetailsInfo;
import org.testingzone.vo.doctor.query.DoctorSummaryInfo;

import java.util.List;


@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorSummaryQuery doctorSummaryQuery;

    @Autowired
    private DoctorDetailsQuery doctorDetailsQuery;

    @Override
    public SummaryPageInfo<DoctorSummaryInfo> getDoctorSummaryPageInfo(SimpleFilter filter, PageFilter pageFilter, SortFilter sortFilter) {
        return doctorSummaryQuery.getSummaryPageInfo(filter, pageFilter, sortFilter);
    }

    @Override
    public List<DoctorSummaryInfo> getDoctorSummaries(SimpleFilter filter, PageFilter pageFilter, SortFilter sortFilter) {
        return doctorSummaryQuery.getSummaryInfoList(filter, pageFilter, sortFilter);
    }

    @Override
    public DoctorDetailsInfo getDoctorDetails(String id) {
        BinaryKey doctorPK = BinaryKey.valueOf(id);
        return doctorDetailsQuery.getDoctorDetailsInfo(doctorPK);
    }

    @Override
    public String createDoctor(DoctorDetailsData doctorDetailsData) {
        return "";
    }

    @Override
    public void updateDoctor(DoctorDetailsData doctorDetailsData) {

    }
}
