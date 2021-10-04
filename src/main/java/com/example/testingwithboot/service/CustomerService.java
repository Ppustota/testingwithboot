package com.example.testingwithboot.service;

import com.example.testingwithboot.model.Customer;
import com.example.testingwithboot.repo.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService implements CService {
    private final CustomerRepo customerRepo;

    public List<Customer> findAllCustomers(){
        return customerRepo.findAll();
    }
    public Customer findByName(String name){
        return customerRepo.findByName(name);
    }
}
