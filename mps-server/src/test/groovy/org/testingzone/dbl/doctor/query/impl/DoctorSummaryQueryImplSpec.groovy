package org.testingzone.dbl.doctor.query.impl

import org.springframework.beans.factory.annotation.Autowired
import org.testingzone.dbl.BaseSpecification
import org.testingzone.dbl.doctor.query.DoctorSummaryQuery
import org.testingzone.vo.base.SimpleFilter

class DoctorSummaryQueryImplSpec extends BaseSpecification {

    @Autowired
    private DoctorSummaryQuery doctorSummaryQuery;

    def "count with empty filter"() {
        given:
        def filter = SimpleFilter.EMPTY;
        when:
        def count = doctorSummaryQuery.count(filter);
        then:
        count == 0l;
    }

    def "count with business filter"() {
        given:
        def filter = new SimpleFilter("31", null);
        when:
        def count = doctorSummaryQuery.count(filter);
        then:
        count == 0l;
    }

    def "count with business and search text"() {
        given:
        def filter = new SimpleFilter("31", "test");
        when:
        def count = doctorSummaryQuery.count(filter);
        then:
        count == 0l;
    }
}
