package org.testingzone.service.doctor;

import org.testingzone.vo.base.PageFilter;
import org.testingzone.vo.base.SortFilter;
import org.testingzone.vo.base.SummaryPageInfo;
import org.testingzone.vo.doctor.DoctorDetailsInfo;
import org.testingzone.vo.doctor.DoctorSummaryInfo;
import org.testingzone.vo.base.SimpleFilter;

import java.util.List;

public interface DoctorService {

    SummaryPageInfo<DoctorSummaryInfo> getDoctorSummaryPageInfo(SimpleFilter filter, PageFilter pageFilter, SortFilter sortFilter);

    List<DoctorSummaryInfo> getDoctorSummaries(SimpleFilter filter, PageFilter pageFilter, SortFilter sortFilter);

    DoctorDetailsInfo getDoctorDetails(String doctorPK);
}
