package com.example.testingwithboot.service;

import com.example.testingwithboot.model.Customer;

import java.util.List;

public interface CService {
    List<Customer> findAllCustomers();
    Customer findByName(String name);
}
