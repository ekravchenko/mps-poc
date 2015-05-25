package org.testingzone.service.doctor;

import com.google.gwt.user.client.rpc.AsyncCallback;
import org.testingzone.vo.base.PageFilter;
import org.testingzone.vo.base.SimpleFilter;
import org.testingzone.vo.base.SortFilter;
import org.testingzone.vo.base.SummaryPageInfo;
import org.testingzone.vo.doctor.query.DoctorDetailsInfo;
import org.testingzone.vo.doctor.query.DoctorSummaryInfo;

public interface RpcDoctorServiceAsync {
    void getDoctorSummaryPageInfo(SimpleFilter filter, PageFilter pageFilter, SortFilter sortFilter, AsyncCallback<SummaryPageInfo<DoctorSummaryInfo>> async);

    void getDoctorDetails(String doctorPK, AsyncCallback<DoctorDetailsInfo> async);
}
