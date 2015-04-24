package org.testingzone.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.testingzone.service.doctor.DoctorService;
import org.testingzone.service.doctor.DoctorServicePath;
import org.testingzone.vo.doctor.DoctorSummaryInfo;
import org.testingzone.vo.doctor.SimpleFilter;

import java.util.List;

@RestController
@RequestMapping(value = DoctorServicePath.DOCTORS)
public class RestDoctorService {

    private DoctorService doctorService;

    @Autowired
    public RestDoctorService(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<DoctorSummaryInfo> getDoctorSummaries(@RequestParam(value = "businessPK") String businessPK,
                                                      @RequestParam(value = "text", required = false) String text) {
        SimpleFilter filter = new SimpleFilter(businessPK, text);
        return doctorService.getDoctorSummaries(filter);
    }
}
