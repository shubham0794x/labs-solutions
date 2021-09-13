package com.ironhack.lab46.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.lab46.controller.dto.DoctorDTO;
import com.ironhack.lab46.controller.dto.DoctorDepartmentDTO;
import com.ironhack.lab46.controller.dto.DoctorStatusDTO;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DoctorControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();


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
        MvcResult result = mockMvc.perform(get("/doctors")).andExpect(status().isOk()).andReturn();
        assertTrue(result.getResponse().getContentAsString().contains("Alonso Flores"));
        assertTrue(result.getResponse().getContentAsString().contains("German Ruiz"));
        assertTrue(result.getResponse().getContentAsString().contains("Paolo Rodriguez"));
    }

    @Test
    void findByEmployeeId_withRegisters_listOfRegisters() throws Exception {
        MvcResult result = mockMvc.perform(get("/doctors/356712")).andExpect(status().isOk()).andReturn();
        assertTrue(result.getResponse().getContentAsString().contains("Alonso Flores"));
    }

    @Test
    void findByEmployeeIdOrStatusOrDepartment_noExistentRegisters_notFound() throws Exception {
        mockMvc.perform(get("/doctors/14")).andExpect(status().isNotFound()).andReturn();
    }


    @Test
    void store_newDoctor_newDoctor() throws Exception {
        DoctorDTO doctorDTO;
        doctorDTO = new DoctorDTO();
        doctorDTO.setEmployeeId("123456");
        doctorDTO.setName("Pepe");
        doctorDTO.setStatus("OFF");
        doctorDTO.setDepartment("immunology");
        String body = objectMapper.writeValueAsString(doctorDTO);
        MvcResult result = mockMvc.perform(post("/doctors").content(body)
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated()).andReturn();
        assertTrue(result.getResponse().getContentAsString().contains("Pepe"));
    }

    @Test
    void updateStatus_updateStatus_noContent() throws Exception {
        DoctorStatusDTO doctorStatusDTO = new DoctorStatusDTO();
        doctorStatusDTO.setStatus("OFF");
        String body = objectMapper.writeValueAsString(doctorStatusDTO);
        mockMvc.perform(patch("/doctors/166552/status").content(body)
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNoContent()).andReturn();
        assertEquals(doctorRepository.findById("166552").get().getStatus(), EmployeeStatus.OFF);
        doctorStatusDTO.setStatus("ON");
        body = objectMapper.writeValueAsString(doctorStatusDTO);
        mockMvc.perform(patch("/doctors/166552/status").content(body)
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNoContent()).andReturn();
        assertEquals(doctorRepository.findById("166552").get().getStatus(), EmployeeStatus.ON);
    }

    @Test
    void updateDepartment_updateDepartment_noContent() throws Exception {
        DoctorDepartmentDTO doctorDepartmentDTO = new DoctorDepartmentDTO();
        doctorDepartmentDTO.setDepartment("orthopaedic");
        String body = objectMapper.writeValueAsString(doctorDepartmentDTO);
        mockMvc.perform(patch("/doctors/166552/department").content(body)
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNoContent()).andReturn();
        assertEquals(doctorRepository.findById("166552").get().getDepartment(), "orthopaedic");
        doctorDepartmentDTO.setDepartment("pulmonary");
        body = objectMapper.writeValueAsString(doctorDepartmentDTO);
        mockMvc.perform(patch("/doctors/166552/department").content(body)
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNoContent()).andReturn();
        assertEquals(doctorRepository.findById("166552").get().getDepartment(), "pulmonary");
    }

    public static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

}