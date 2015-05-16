package org.testingzone.client.service;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;
import org.testingzone.service.BaseConstants;
import org.testingzone.service.doctor.DoctorConstants;
import org.testingzone.vo.base.SortOrder;
import org.testingzone.vo.base.SummaryPageInfo;
import org.testingzone.vo.doctor.DoctorSortProperty;
import org.testingzone.vo.doctor.query.DoctorDetailsInfo;
import org.testingzone.vo.doctor.query.DoctorSummaryInfo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

public interface DoctorService extends RestService {

    @Path(DoctorConstants.Uri.DOCTORS_PAGE)
    @GET
    void getDoctorSummaryPageInfo(
            @PathParam(BaseConstants.Path.BUSINESS_ID)
            String businessPK,
            @QueryParam(BaseConstants.Query.SEARCH)
            String text,
            @QueryParam(BaseConstants.Query.PAGE_INDEX)
            int pageIndex,
            @QueryParam(BaseConstants.Query.ITEMS_PER_PAGE)
            int itemsPerPage,
            @QueryParam(BaseConstants.Query.SORT_PROPERTY)
            DoctorSortProperty sort,
            @QueryParam(BaseConstants.Query.SORT_ORDER)
            SortOrder order,
            MethodCallback<SummaryPageInfo<DoctorSummaryInfo>> callback);

    @Path(DoctorConstants.Uri.DOCTOR_DETAILS)
    @GET
    void getDoctorDetails(@PathParam(DoctorConstants.Path.DOCTOR_ID) String id,
                          MethodCallback<DoctorDetailsInfo> callback);
}
