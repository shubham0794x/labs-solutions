package com.ironhack.lab42.controller;

import com.ironhack.lab42.enums.EmployeeStatus;
import com.ironhack.lab42.model.Patient;
import com.ironhack.lab42.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/patients")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @GetMapping("/patients/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Patient findById(@PathVariable Integer id) {
        return patientRepository.findById(id).get();
    }

    @GetMapping("/patients/between-date-of-birth")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> findBetweenDateOfBirth(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date start, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date end) {
        return patientRepository.findByDateOfBirthBetween(start, end);
    }

    @GetMapping("/patients/doctor-department/{department}")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> findByDoctorDepartment(@PathVariable String department) {
        return patientRepository.findByAdmittedByDepartment(department);
    }

    @GetMapping("/patients/off-doctor")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> findByDoctorStatus() {
        return patientRepository.findByAdmittedByStatus(EmployeeStatus.OFF);
    }
}
