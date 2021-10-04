package com.example.testingwithboot.controller;

import com.example.testingwithboot.model.Customer;
import com.example.testingwithboot.service.CService;
import com.example.testingwithboot.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v2")
@AllArgsConstructor
public class CustomerController {
    private final CService customerService;

    @GetMapping
    public List<Customer> findALlCustomers(){
        return customerService.findAllCustomers();
    }
    @GetMapping("/customers")
    public Customer findByName(@RequestParam String name){
        return customerService.findByName(name);
    }

}
