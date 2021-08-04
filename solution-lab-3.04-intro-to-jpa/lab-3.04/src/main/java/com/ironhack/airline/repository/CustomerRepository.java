package com.ironhack.airline.repository;

import com.ironhack.airline.enums.CustomerStatus;
import com.ironhack.airline.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Optional<Customer> findByName(String name);
    List<Customer> findByStatus(CustomerStatus status);

}
