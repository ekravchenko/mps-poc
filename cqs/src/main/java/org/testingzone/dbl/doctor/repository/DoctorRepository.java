package org.testingzone.dbl.doctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.testingzone.dbo.base.BinaryKey;
import org.testingzone.dbo.doctor.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, BinaryKey> {
}
