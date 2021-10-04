package com.example.testingwithboot.service;

import org.springframework.stereotype.Service;

@Service
public class SimpleService implements SService {
    public String sayHello(){
        return "Hello world!";
    }
}
