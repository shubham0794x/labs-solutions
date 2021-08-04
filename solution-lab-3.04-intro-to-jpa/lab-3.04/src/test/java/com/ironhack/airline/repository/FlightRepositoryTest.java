package com.ironhack.airline.repository;

import com.ironhack.airline.model.Aircraft;
import com.ironhack.airline.model.Customer;
import com.ironhack.airline.model.Flight;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class FlightRepositoryTest {

    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AircraftRepository aircraftRepository;

    private String aircraft1Model;

    @BeforeEach
    void setUp() {
        Aircraft aircraft1 = aircraftRepository.save(new Aircraft("Airbus 330",300));
        Aircraft aircraft2 = aircraftRepository.save(new Aircraft("Boeing 747",280));

        aircraft1Model = aircraft1.getModel();

        Flight flight1 = new Flight("B120", 400L, aircraft1.getModel());
        Flight flight2 = new Flight("B220", 600L, aircraft2.getModel());
        Flight flight3 = new Flight("B230", 600L, aircraft2.getModel());
        flightRepository.save(flight1);
        flightRepository.save(flight2);
        flightRepository.save(flight3);
    }

    @AfterEach
    public void tearDown() {
        flightRepository.deleteAll();
        customerRepository.deleteAll();
        aircraftRepository.deleteAll();
    }

    @Test
    void saveFlight_successful() {
        assertEquals(3, flightRepository.findAll().size());
        flightRepository.save(new Flight("B240", 600L, aircraft1Model));
        assertEquals(4, flightRepository.findAll().size());
    }


    @Test
    void findByNumber_validNumber_Flight() {
        Optional<Flight> flightOptional = flightRepository.findById("B220");
        assertTrue(flightOptional.isPresent());
        assertEquals("B220", flightOptional.get().getNumber());
    }

    @Test
    void findFlightsByFlightMileageGreaterThan500() {
        List<Flight> flights = flightRepository.findByMileageGreaterThan(500L);
        assertEquals(2, flights.size());
        assertEquals("B220", flights.get(0).getNumber());
    }
}