package com.HospitalAPI.Hospital.API.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HospitalAPI.Hospital.API.ModelClasses.Patient;
import com.HospitalAPI.Hospital.API.ModelClasses.Report;

import ch.qos.logback.core.status.Status;

public interface ReportRepository extends JpaRepository<Report, Long> {
    List<Report> findAllByPatientOrderByDateAsc(Patient patient);
    List<Report> findAllByStatus(jakarta.transaction.Status reportStatus);
}
