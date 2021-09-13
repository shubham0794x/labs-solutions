package com.ironhack.lab46.service.interfaces;

import com.ironhack.lab46.controller.dto.PatientDTO;
import com.ironhack.lab46.model.Patient;

import java.text.ParseException;

public interface IPatientService {
    Patient store(PatientDTO patientDTO) throws ParseException;

    void update(int id, PatientDTO patientDTO);
}
