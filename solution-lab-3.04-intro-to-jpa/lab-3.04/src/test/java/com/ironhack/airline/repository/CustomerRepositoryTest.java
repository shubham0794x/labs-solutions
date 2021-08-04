package com.ironhack.airline.repository;

import com.ironhack.airline.enums.CustomerStatus;
import com.ironhack.airline.model.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    private Integer customer1Id;
    private Integer customer2Id;
    private Integer customer3Id;

    @BeforeEach
    void setUp() {

        Customer customer = customerRepository.save(new Customer( "Jaume", CustomerStatus.Gold));
        Customer customer2 = customerRepository.save(customer = new Customer( "Maria", CustomerStatus.Gold));
        Customer customer3 = customerRepository.save(customer = new Customer("Pepe", CustomerStatus.None));

        customer1Id = customer.getId();
        customer2Id = customer2.getId();
        customer3Id = customer3.getId();

    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }

    @Test
    void saveCustomer_successful() {
        assertEquals(3, customerRepository.findAll().size());
        Customer customer = customerRepository.save(new Customer("Lola", CustomerStatus.Silver));
        assertNotNull(customer.getId());
    }

    @Test
    void findByName_validName_Customer() {
        Optional<Customer> customerOptional = customerRepository.findByName("Jaume");
        assertTrue(customerOptional.isPresent());
        assertEquals("Jaume", customerOptional.get().getName());
    }

    @Test
    void findByStatus_validStatus_Customer() {
        assertEquals(2, customerRepository.findByStatus(CustomerStatus.Gold).size());
    }

}