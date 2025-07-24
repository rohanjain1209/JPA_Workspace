package com.example.jpa_hibernate.pagination;

import com.example.jpa_hibernate.MySqlConnect.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeePaginationService {
    @Autowired
    private EmployeePaginatedRepository employeeRepo;
    public Page<Employee> getPaginatedEmployees(Pageable pageable) {
        return employeeRepo.findAll(pageable);
    }
}
