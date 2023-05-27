package com.HospitalAPI.Hospital.API.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HospitalAPI.Hospital.API.ModelClasses.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Doctor findByUsername(String username);
}

