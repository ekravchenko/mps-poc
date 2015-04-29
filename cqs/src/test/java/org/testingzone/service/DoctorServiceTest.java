package org.testingzone.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.testingzone.config.MyConfig;
import org.testingzone.service.doctor.DoctorService;
import org.testingzone.vo.base.PageFilter;
import org.testingzone.vo.base.SortFilter;
import org.testingzone.vo.doctor.query.DoctorSummaryInfo;
import org.testingzone.vo.base.SimpleFilter;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MyConfig.class}, loader = AnnotationConfigContextLoader.class)
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