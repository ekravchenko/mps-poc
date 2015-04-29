package org.testingzone.client.service;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;
import org.testingzone.service.doctor.DoctorServiceConstants;
import org.testingzone.vo.base.SortOrder;
import org.testingzone.vo.base.SummaryPageInfo;
import org.testingzone.vo.doctor.query.DoctorDetailsInfo;
import org.testingzone.vo.doctor.DoctorSortProperty;
import org.testingzone.vo.doctor.query.DoctorSummaryInfo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

@Path(DoctorServiceConstants.DOCTORS)
public interface DoctorService extends RestService {

    @Path(DoctorServiceConstants.DOCTORS_PAGE_INITIAL)
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
            @QueryParam("sort")
            DoctorSortProperty sort,
            @QueryParam("order")
            SortOrder order,
            MethodCallback<SummaryPageInfo<DoctorSummaryInfo>> callback);

    @Path(DoctorServiceConstants.DOCTOR_DETAILS)
    @GET
    void getDoctorDetails(@PathParam(DoctorServiceConstants.DOCTOR_ID) String id,
                          MethodCallback<DoctorDetailsInfo> callback);
}
