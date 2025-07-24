package com.example.jpa_hibernate.MySqlConnect;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public List<Employee> getAllUsers() {
        return employeeRepository.findAll();
    }

    @PostMapping
    public Employee saveUser(@RequestBody Employee user) {
        return employeeRepository.save(user);
    }
}
