package org.testingzone.client.service;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;
import org.testingzone.service.doctor.DoctorServicePath;
import org.testingzone.vo.base.SummaryPageInfo;
import org.testingzone.vo.doctor.DoctorSummaryInfo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.util.List;

@Path(DoctorServicePath.DOCTORS)
public interface DoctorService extends RestService {

    @GET
    void getDoctorSummaryPageInfo(
            @QueryParam("businessPK")
            String businessPK,
            @QueryParam("text")
            String text,
            @QueryParam("pageIndex")
            int pageIndex,
            @QueryParam("itemsPerPage")
            int itemsPerPage,
            MethodCallback<SummaryPageInfo<DoctorSummaryInfo>> callback);
}
