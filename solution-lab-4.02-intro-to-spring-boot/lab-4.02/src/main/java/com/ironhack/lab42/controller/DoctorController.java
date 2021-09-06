package com.ironhack.lab42.controller;

import com.ironhack.lab42.enums.EmployeeStatus;
import com.ironhack.lab42.model.Doctor;
import com.ironhack.lab42.model.Patient;
import com.ironhack.lab42.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DoctorController {
    @Autowired
    private DoctorRepository doctorRepository;


    @GetMapping("/doctors")
    @ResponseStatus(HttpStatus.OK)
    public List<Doctor> search(@RequestParam Optional<EmployeeStatus> status, @RequestParam Optional<String> department) {
        if (status.isPresent()) {
            return doctorRepository.findByStatus(status.get());
        } else if (department.isPresent()) {
            return doctorRepository.findByDepartment(department.get());
        } else {
            return doctorRepository.findAll();
        }
    }

    @GetMapping("/doctors/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Doctor findById(@PathVariable String id) {
        return doctorRepository.findById(id).get();
    }

}
