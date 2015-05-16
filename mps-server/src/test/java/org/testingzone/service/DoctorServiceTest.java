package org.testingzone.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.testingzone.Application;
import org.testingzone.service.doctor.DoctorService;
import org.testingzone.vo.base.PageFilter;
import org.testingzone.vo.base.SimpleFilter;
import org.testingzone.vo.base.SortFilter;
import org.testingzone.vo.doctor.query.DoctorSummaryInfo;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@ActiveProfiles("test")
public class DoctorServiceTest {

    @Autowired
    private DoctorService doctorService;

    @Test
    public void testGetSummaries() {
        List<DoctorSummaryInfo> doctorSummaries = doctorService.getDoctorSummaries(SimpleFilter.EMPTY, PageFilter.NONE, SortFilter.NONE);
        Assert.assertNotNull(doctorSummaries);
        Assert.assertEquals(2, doctorSummaries.size());
    }
}