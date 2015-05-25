package org.testingzone.web.rpc;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.testingzone.service.doctor.RpcDoctorService;
import org.testingzone.vo.base.PageFilter;
import org.testingzone.vo.base.SimpleFilter;
import org.testingzone.vo.base.SortFilter;
import org.testingzone.vo.base.SummaryPageInfo;
import org.testingzone.vo.doctor.query.DoctorDetailsInfo;
import org.testingzone.vo.doctor.query.DoctorSummaryInfo;

@Transactional
@Service("doctorService")
public class RpcDoctorServiceImpl implements RpcDoctorService {

    @Override
    public SummaryPageInfo<DoctorSummaryInfo> getDoctorSummaryPageInfo(SimpleFilter filter, PageFilter pageFilter, SortFilter sortFilter) {
        return null;
    }

    @Override
    public DoctorDetailsInfo getDoctorDetails(String doctorPK) {
        return null;
    }
}
