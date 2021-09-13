package com.ironhack.lab46.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.lab46.controller.dto.PatientDTO;
import com.ironhack.lab46.enums.EmployeeStatus;
import com.ironhack.lab46.model.Doctor;
import com.ironhack.lab46.model.Patient;
import com.ironhack.lab46.repository.DoctorRepository;
import com.ironhack.lab46.repository.PatientRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class PatientControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper = new ObjectMapper();
    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");


    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        List<Doctor> doctors = doctorRepository.saveAll(
                List.of(
                        new Doctor("356712", "cardiology", "Alonso Flores", EmployeeStatus.ON_CALL),
                        new Doctor("564134", "immunology", "Sam Ortega", EmployeeStatus.ON),
                        new Doctor("761527", "cardiology", "German Ruiz", EmployeeStatus.OFF),
                        new Doctor("166552", "pulmonary", "Maria Lin", EmployeeStatus.ON),
                        new Doctor("156545", "orthopaedic", "Paolo Rodriguez", EmployeeStatus.ON_CALL),
                        new Doctor("172456", "psychiatric", "John Paul Armes", EmployeeStatus.OFF)
                )
        );

        patientRepository.saveAll(
                List.of(
                        new Patient("Jaime Jordan", parseDate("1984-03-02"), doctors.get(1)),
                        new Patient("Marian Garcia", parseDate("1972-01-12"), doctors.get(1)),
                        new Patient("Julia Dusterdieck", parseDate("1954-06-11"), doctors.get(0)),
                        new Patient("Steve McDuck", parseDate("1931-11-10"), doctors.get(2)),
                        new Patient("Marian Garcia", parseDate("1999-02-15"), doctors.get(5))
                )
        );
    }

    @AfterEach
    void tearDown() {
        patientRepository.deleteAll();
        doctorRepository.deleteAll();
    }

    @Test
    void findAll_withRegisters_listOfRegisters() throws Exception {
        MvcResult result = mockMvc.perform(get("/patients")).andExpect(status().isOk()).andReturn();
        assertTrue(result.getResponse().getContentAsString().contains("Jaime Jordan"));
        assertTrue(result.getResponse().getContentAsString().contains("Julia Dusterdieck"));
        assertTrue(result.getResponse().getContentAsString().contains("Marian Garcia"));
    }

    @Test
    void findBetweenDateOfBirth_correctDates_listOfRegisters() throws Exception {
        MvcResult result = mockMvc.perform(get("/patients/between-date-of-birth?start=1980-01-01&end=2000-01-01"))
                .andExpect(status().isOk()).andReturn();
        assertTrue(result.getResponse().getContentAsString().contains("Jaime Jordan"));
        assertTrue(result.getResponse().getContentAsString().contains("Marian Garcia"));
        assertFalse(result.getResponse().getContentAsString().contains("Steve McDuck"));
    }

    @Test
    void findByDoctorDepartment_correctDepartment_listOfRegisters() throws Exception {
        MvcResult result = mockMvc.perform(get("/patients/doctor-department/cardiology"))
                .andExpect(status().isOk()).andReturn();
        assertTrue(result.getResponse().getContentAsString().contains("Julia Dusterdieck"));
        assertTrue(result.getResponse().getContentAsString().contains("Steve McDuck"));
    }

    @Test
    void findOffDoctors_correctStatus_listOfRegisters() throws Exception {
        MvcResult result = mockMvc.perform(get("/patients/off-doctor"))
                .andExpect(status().isOk()).andReturn();
        assertTrue(result.getResponse().getContentAsString().contains("Marian Garcia"));
        assertTrue(result.getResponse().getContentAsString().contains("Steve McDuck"));
    }

    @Test
    void store_correctRegister_newRegister() throws Exception {
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setDoctorId("356712");
        patientDTO.setName("Pepe");
        patientDTO.setDateOfBirth("1996-04-29");
        String body = objectMapper.writeValueAsString(patientDTO);
        MvcResult result = mockMvc.perform(post("/patients").content(body)
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated()).andReturn();
        assertTrue(result.getResponse().getContentAsString().contains("Pepe"));
    }

    @Test
    void update_updateDate_noContent() throws Exception {
        Patient patient = patientRepository.findById(3).get();

        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setName(patient.getName());
        patientDTO.setDoctorId(patient.getAdmittedBy().getEmployeeId());
        patientDTO.setDateOfBirth("1996-04-29");

        String body = objectMapper.writeValueAsString(patientDTO);

        mockMvc.perform(put("/patients/3").content(body)
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNoContent()).andReturn();

        patient = patientRepository.findById(3).get();
        assertEquals("Julia Dusterdieck", patient.getName());
        assertEquals("1996-04-29", formatter.format(patient.getDateOfBirth()));
        assertEquals("356712", patient.getAdmittedBy().getEmployeeId());

    }

    @Test
    void update_updateName_noContent() throws Exception {
        Patient patient = patientRepository.findById(3).get();
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setDateOfBirth(formatter.format(patient.getDateOfBirth()));
        patientDTO.setName("Pepe");
        patientDTO.setDoctorId(patient.getAdmittedBy().getEmployeeId());

        String body = objectMapper.writeValueAsString(patientDTO);

        mockMvc.perform(put("/patients/3").content(body)
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNoContent()).andReturn();

        patient = patientRepository.findById(3).get();

        assertEquals("Pepe", patient.getName());
        assertEquals("1954-06-11", formatter.format(patient.getDateOfBirth()));
        assertEquals("356712", patient.getAdmittedBy().getEmployeeId());

    }

    @Test
    void update_updateDoctor_noContent() throws Exception {
        Patient patient = patientRepository.findById(3).get();

        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setDateOfBirth(formatter.format(patient.getDateOfBirth()));
        patientDTO.setName(patient.getName());
        patientDTO.setDoctorId("564134");

        String body = objectMapper.writeValueAsString(patientDTO);


        mockMvc.perform(put("/patients/3").content(body)
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNoContent()).andReturn();

        patient = patientRepository.findById(3).get();

        assertEquals("Julia Dusterdieck", patient.getName());
        assertEquals("1954-06-11", formatter.format(patient.getDateOfBirth()));
        assertEquals("564134", patient.getAdmittedBy().getEmployeeId());

    }

    public static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }
}