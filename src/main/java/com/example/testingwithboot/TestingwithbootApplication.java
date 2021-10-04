package com.example.testingwithboot;

import com.example.testingwithboot.model.Customer;
import com.example.testingwithboot.repo.CustomerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TestingwithbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestingwithbootApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepo customerRepo){
        return args -> {
          customerRepo.save(new Customer(null, "giorgi"));
        };
    }

}
