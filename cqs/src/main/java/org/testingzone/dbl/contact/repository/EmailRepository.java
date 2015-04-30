package org.testingzone.dbl.contact.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.testingzone.dbo.base.BinaryKey;
import org.testingzone.dbo.contact.ContactEmail;

public interface EmailRepository extends JpaRepository<ContactEmail, BinaryKey> {

    @Query("select e from ContactEmail e left join a.contact c where c.contactPk=:contact")
    ContactEmail findEmail(@Param("contact") BinaryKey contactPK);
}
