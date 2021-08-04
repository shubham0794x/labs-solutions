package com.ironhack.airline.repository;

import com.ironhack.airline.model.Aircraft;
import com.ironhack.airline.model.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AircraftRepositoryTest {
    @Autowired
    private AircraftRepository aircraftRepository;

    @BeforeEach
    void setUp() {
        Aircraft aircraft1 = aircraftRepository.save(new Aircraft("Airbus 330",300));
        Aircraft aircraft2 = aircraftRepository.save(new Aircraft("Boeing 747",280));
        Aircraft aircraft3 = aircraftRepository.save(new Aircraft("Boeing 777",290));
    }

    @AfterEach
    void tearDown() {
        aircraftRepository.deleteAll();
    }

    @Test
    void saveAircraft_successful() {
        assertEquals(3, aircraftRepository.findAll().size());
        Aircraft aircraft = aircraftRepository.save(new Aircraft("Airbus 666",666));
        assertEquals(4, aircraftRepository.findAll().size());
    }

    @Test
    void findByModelContains_model_Aircraft() {
        assertEquals(2, aircraftRepository.findByModelContains("Boeing").size());
    }

}