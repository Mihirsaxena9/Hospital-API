package com.HospitalAPI.Hospital.API.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.HospitalAPI.Hospital.API.ModelClasses.Doctor;
import com.HospitalAPI.Hospital.API.Repository.DoctorRepository;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    private DoctorRepository doctorRepository;

    @Autowired
    public DoctorController(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @PostMapping("/register")
    public String registerDoctor(@RequestBody Doctor doctor) {
        String hashedPassword = new BCryptPasswordEncoder().encode(doctor.getPassword());
        doctor.setPassword(hashedPassword);
        doctorRepository.save(doctor);
        return "Doctor registered successfully!";
    }
}



