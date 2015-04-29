package org.testingzone.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.testingzone.service.doctor.DoctorService;
import org.testingzone.service.doctor.DoctorServiceConstants;
import org.testingzone.vo.base.*;
import org.testingzone.vo.doctor.query.DoctorDetailsInfo;
import org.testingzone.vo.doctor.query.DoctorSummaryInfo;

import java.util.List;

@RestController
@RequestMapping(value = DoctorServiceConstants.DOCTORS)
public class RestDoctorService {

    private DoctorService doctorService;

    @Autowired
    public RestDoctorService(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @RequestMapping(method = RequestMethod.GET, value = DoctorServiceConstants.DOCTORS_PAGE)
    public List<DoctorSummaryInfo> getDoctorSummaries(@RequestParam(value = "businessPK") String businessPK,
                                                      @RequestParam(value = "text", required = false) String text,
                                                      @RequestParam(value = "pageIndex") int pageIndex,
                                                      @RequestParam(value = "itemsPerPage") int itemsPerPage,
                                                      @RequestParam(value = "sort", required = false) String sort,
                                                      @RequestParam(value = "order", required = false) String order) {
        SimpleFilter filter = new SimpleFilter(businessPK, text);
        PageFilter pageFilter = new PageFilter(pageIndex, itemsPerPage);
        SortFilter sortFilter = new SortFilter(sort, SortOrder.from(order));
        return doctorService.getDoctorSummaries(filter, pageFilter, sortFilter);
    }

    @RequestMapping(method = RequestMethod.GET, value = DoctorServiceConstants.DOCTORS_PAGE_INITIAL)
    public SummaryPageInfo<DoctorSummaryInfo> getPageInfo(@RequestParam(value = "businessPK") String businessPK,
                                                          @RequestParam(value = "text", required = false) String text,
                                                          @RequestParam(value = "pageIndex") int pageIndex,
                                                          @RequestParam(value = "itemsPerPage") int itemsPerPage,
                                                          @RequestParam(value = "sort", required = false) String sort,
                                                          @RequestParam(value = "order", required = false) String order) {
        SimpleFilter filter = new SimpleFilter(businessPK, text);
        PageFilter pageFilter = new PageFilter(pageIndex, itemsPerPage);
        SortFilter sortFilter = new SortFilter(sort, SortOrder.from(order));
        return doctorService.getDoctorSummaryPageInfo(filter, pageFilter, sortFilter);
    }

    @RequestMapping(method = RequestMethod.GET, value = DoctorServiceConstants.DOCTOR_DETAILS)
    public DoctorDetailsInfo getDoctorDetails(@PathVariable(DoctorServiceConstants.DOCTOR_ID) String doctorPK) {
        return doctorService.getDoctorDetails(doctorPK);
    }
}
