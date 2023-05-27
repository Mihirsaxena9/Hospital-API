package com.HospitalAPI.Hospital.API.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.*;

import com.HospitalAPI.Hospital.API.ModelClasses.Doctor;
import com.HospitalAPI.Hospital.API.ModelClasses.Patient;
import com.HospitalAPI.Hospital.API.ModelClasses.Report;
import com.HospitalAPI.Hospital.API.Repository.PatientRepository;

@RestController
@RequestMapping("/patients")
public class PatientController {
    private PatientRepository patientRepository;
	private CrudRepository<Patient, Long> reportRepository;

    @Autowired
    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @PostMapping("/register")
    public String registerPatient(@RequestBody Patient patient) {
        patientRepository.save(patient);
        return "Patient registered successfully!";
    }

    @PostMapping("/{id}/create_report")
    public String createReport(@PathVariable Long id, @RequestBody Report report) {
        // Find patient by ID
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found!"));

        Doctor doctor;
		// Set doctor and patient in the report
        report.setDoctor(doctor);
        report.setPatient(patient);

        // Save the report
        reportRepository.save(report);

        return "Report created successfully!";
    }

    @GetMapping("/{id}/all_reports")
    public List<Report> getAllReports(@PathVariable Long id) {
        // Find patient by ID
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found!"));

        // Get all reports for the patient, ordered by date ascending
        return ((Object) reportRepository).findAllByPatientOrderByDateAsc(patient);
    }
}

