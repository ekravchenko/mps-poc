package org.testingzone.service
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import org.testingzone.Application
import org.testingzone.service.doctor.DoctorService
import spock.lang.Specification

@ContextConfiguration(loader = SpringApplicationContextLoader.class, classes = Application.class)
@ActiveProfiles("test")
class DoctorServiceSpec extends Specification {

    @Autowired
    DoctorService doctorService;

    def "empty"() {
        expect:
        doctorService != null
    }
}
