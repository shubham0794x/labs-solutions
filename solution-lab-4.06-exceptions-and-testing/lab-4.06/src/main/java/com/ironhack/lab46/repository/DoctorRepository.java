package com.ironhack.lab46.repository;

import com.ironhack.lab46.enums.EmployeeStatus;
import com.ironhack.lab46.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, String> {

    List<Doctor> findByStatus(EmployeeStatus status);

    List<Doctor> findByDepartment(String department);

}
