package org.testingzone.service.doctor;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import org.testingzone.vo.base.PageFilter;
import org.testingzone.vo.base.SimpleFilter;
import org.testingzone.vo.base.SortFilter;
import org.testingzone.vo.base.SummaryPageInfo;
import org.testingzone.vo.doctor.query.DoctorDetailsInfo;
import org.testingzone.vo.doctor.query.DoctorSummaryInfo;

@RemoteServiceRelativePath("services/doctorService")
public interface RpcDoctorService extends RemoteService {

    SummaryPageInfo<DoctorSummaryInfo> getDoctorSummaryPageInfo(SimpleFilter filter, PageFilter pageFilter, SortFilter sortFilter);

    DoctorDetailsInfo getDoctorDetails(String doctorPK);
}
