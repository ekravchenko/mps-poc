package org.testingzone.dbl.contact.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.testingzone.dbo.base.BinaryKey;
import org.testingzone.dbo.contact.Contact;

public interface ContactRepository extends JpaRepository<Contact, BinaryKey> {
}
