package org.testingzone.dbl

import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import org.testingzone.Application
import spock.lang.Specification

@ContextConfiguration(loader = SpringApplicationContextLoader.class, classes = Application.class)
@ActiveProfiles("test")
public abstract class BaseSpecification extends Specification {
}
