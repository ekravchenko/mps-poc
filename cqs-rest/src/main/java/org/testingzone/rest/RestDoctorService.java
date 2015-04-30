package org.testingzone.rest;


import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.testingzone.service.BaseConstants;
import org.testingzone.service.doctor.DoctorConstants;
import org.testingzone.service.doctor.DoctorService;
import org.testingzone.vo.base.*;
import org.testingzone.vo.doctor.data.DoctorDetailsData;
import org.testingzone.vo.doctor.query.DoctorDetailsInfo;
import org.testingzone.vo.doctor.query.DoctorSummaryInfo;

import java.util.List;

@RequestMapping
@RestController
public class RestDoctorService {

    private DoctorService doctorService;

    @Autowired
    public RestDoctorService(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @RequestMapping(method = RequestMethod.GET, value = DoctorConstants.Uri.DOCTORS)
    public List<DoctorSummaryInfo> getDoctorSummaries(@PathVariable(value = BaseConstants.Path.BUSINESS_ID) String businessPK,
                                                      @RequestParam(value = BaseConstants.Query.SEARCH, required = false) String text,
                                                      @RequestParam(value = BaseConstants.Query.PAGE_INDEX, required = false) Integer pageIndex,
                                                      @RequestParam(value = BaseConstants.Query.ITEMS_PER_PAGE, required = false) Integer itemsPerPage,
                                                      @RequestParam(value = BaseConstants.Query.SORT_PROPERTY, required = false) String sort,
                                                      @RequestParam(value = BaseConstants.Query.SORT_ORDER, required = false) String order) {
        SimpleFilter filter = new SimpleFilter(businessPK, text);
        PageFilter pageFilter = PageFilter.create(pageIndex, itemsPerPage);
        SortFilter sortFilter = SortFilter.create(sort, SortOrder.from(order));
        return doctorService.getDoctorSummaries(filter, pageFilter, sortFilter);
    }

    @RequestMapping(method = RequestMethod.GET, value = DoctorConstants.Uri.DOCTORS_PAGE)
    public SummaryPageInfo<DoctorSummaryInfo> getPageInfo(@PathVariable(value = BaseConstants.Path.BUSINESS_ID) String businessPK,
                                                          @RequestParam(value = BaseConstants.Query.SEARCH, required = false) String text,
                                                          @RequestParam(value = BaseConstants.Query.PAGE_INDEX, required = false) Integer pageIndex,
                                                          @RequestParam(value = BaseConstants.Query.ITEMS_PER_PAGE, required = false) Integer itemsPerPage,
                                                          @RequestParam(value = BaseConstants.Query.SORT_PROPERTY, required = false) String sort,
                                                          @RequestParam(value = BaseConstants.Query.SORT_ORDER, required = false) String order) {
        SimpleFilter filter = new SimpleFilter(businessPK, text);
        PageFilter pageFilter = PageFilter.create(pageIndex, itemsPerPage);
        SortFilter sortFilter = SortFilter.create(sort, SortOrder.from(order));
        return doctorService.getDoctorSummaryPageInfo(filter, pageFilter, sortFilter);
    }

    @RequestMapping(method = RequestMethod.GET, value = DoctorConstants.Uri.DOCTOR_DETAILS)
    public DoctorDetailsInfo getDoctorDetails(@PathVariable(DoctorConstants.Path.DOCTOR_ID) String doctorPK) {
        Preconditions.checkArgument(doctorPK != null, "Doctor PK is null");
        return doctorService.getDoctorDetails(doctorPK);
    }

    @RequestMapping(method = RequestMethod.POST, value = DoctorConstants.Uri.DOCTORS)
    public String createDoctorDetails(@PathVariable(value = BaseConstants.Path.BUSINESS_ID) String businessPK,
                                      DoctorDetailsData doctorDetailsData) {
        Preconditions.checkArgument(doctorDetailsData != null, "DoctorDetailsData is null");
        Preconditions.checkArgument(doctorDetailsData.doctorData != null, "DoctorDetailsData.doctorData is null");

        doctorDetailsData.doctorData.businessPK = businessPK;
        return doctorService.createDoctor(doctorDetailsData);
    }

    @RequestMapping(method = RequestMethod.PUT, value = DoctorConstants.Uri.DOCTOR_DETAILS)
    public void updateDoctorDetails(@PathVariable(DoctorConstants.Path.DOCTOR_ID) String doctorPK,
                                    DoctorDetailsData doctorDetailsData) {
        Preconditions.checkArgument(doctorDetailsData != null, "DoctorDetailsData is null");
        Preconditions.checkArgument(doctorDetailsData.doctorData != null, "DoctorDetailsData.doctorData is null");

        doctorDetailsData.doctorData.doctorPK = doctorPK;
        doctorService.updateDoctor(doctorDetailsData);
    }
}
