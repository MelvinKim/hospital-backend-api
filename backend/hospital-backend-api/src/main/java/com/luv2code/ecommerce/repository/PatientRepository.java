package com.luv2code.ecommerce.repository;

import com.luv2code.ecommerce.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
