package com.example.jpa_hibernate.Hibernate;

import com.example.jpa_hibernate.MySqlConnect.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hibernate")
public class HibernateController {

    @Autowired
    private EmployeeHibernateService employeeService;

    @PostMapping("/employee")
    public ResponseEntity<String> saveEmployee(@RequestBody Employee emp) {
        employeeService.saveWithHibernate(emp);
        return ResponseEntity.ok("Saved using Hibernate Session!");
    }
    @PostMapping("/employee/Manual")
    public ResponseEntity<String> saveEmployeeWithManualTransaction(@RequestBody Employee emp) {
        employeeService.saveWithHibernateManualTransaction(emp);
        return ResponseEntity.ok("Saved using Hibernate Session!");
    }
}
