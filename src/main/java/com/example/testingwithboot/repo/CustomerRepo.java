package com.example.testingwithboot.repo;

import com.example.testingwithboot.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
    Customer findByName(String name);
}
