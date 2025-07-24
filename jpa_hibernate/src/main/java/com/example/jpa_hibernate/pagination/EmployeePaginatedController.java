package com.example.jpa_hibernate.pagination;

import com.example.jpa_hibernate.MySqlConnect.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeePaginatedController { 

    @Autowired
    private EmployeePaginationService employeeService;

    @GetMapping("/paginated")
    public Page<Employee> getEmployeesPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return employeeService.getPaginatedEmployees(pageable);
    }
}
