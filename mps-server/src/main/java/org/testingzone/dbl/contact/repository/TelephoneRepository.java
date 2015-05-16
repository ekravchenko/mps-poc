package org.testingzone.dbl.contact.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.testingzone.dbo.base.BinaryKey;
import org.testingzone.dbo.contact.ContactTelephone;

public interface TelephoneRepository extends JpaRepository<ContactTelephone, BinaryKey> {

    @Query("select t from ContactTelephone t left join t.contact c " +
            "where c.contactPk = :contact and t.contactTelephoneType = :type")
    ContactTelephone findTelephone(@Param("contact") BinaryKey contactPK,
                                   @Param("type") Integer telephoneType);
}
