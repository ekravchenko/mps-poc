package org.testingzone.dbl.contact.command.impl

import org.springframework.beans.factory.annotation.Autowired
import org.testingzone.dbl.BaseSpecification
import org.testingzone.dbl.contact.command.SaveEmailCommand
import org.testingzone.dbo.base.SafeBinaryKey
import spock.lang.Ignore

class SaveEmailCommandImplSpec extends BaseSpecification {

    @Autowired
    private SaveEmailCommand saveEmailCommand;

    @Ignore
    def "save new email"() {
        given:
        def email = "test@test.com";
        def contactPK = new SafeBinaryKey("31").key();
        when:
        def emailPK = saveEmailCommand.saveEmail(contactPK, email);
        then:
        emailPK != null;
    }
}
