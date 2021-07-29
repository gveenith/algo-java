package com.practice.curd.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/employee")
public class EmployeeOperations {

    @GetMapping("/list")
    public String listEmployees() {

        return "Hello";

    }

}