package com.HospitalAPI.Hospital.API.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HospitalAPI.Hospital.API.ModelClasses.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByPhoneNumber(String phoneNumber);
}

