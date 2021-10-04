package com.example.testingwithboot.controller;

import com.example.testingwithboot.service.SService;
import com.example.testingwithboot.service.SimpleService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class SimpleController {
    private SService simpleService;

    @GetMapping("/")
    public @ResponseBody String sayHello(){
        return simpleService.sayHello();
    }
}
