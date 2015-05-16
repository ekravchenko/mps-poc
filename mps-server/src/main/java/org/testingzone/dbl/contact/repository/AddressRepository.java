package org.testingzone.dbl.contact.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.testingzone.dbo.base.BinaryKey;
import org.testingzone.dbo.contact.ContactAddress;

public interface AddressRepository extends JpaRepository<ContactAddress, BinaryKey> {

    @Query("select a from ContactAddress a left join a.contact c " +
            "where c.contactPk=:contact and a.contactAddressType=:type")
    ContactAddress findAddress(@Param("contact") BinaryKey contactPK,
                               @Param("type") Integer addressType);

}
