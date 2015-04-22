package org.testingzone.dbl.doctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.testingzone.dbo.BinaryKey;
import org.testingzone.dbo.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, BinaryKey> {
}
