package com.example.jpa_hibernate.transection;

import com.example.jpa_hibernate.MySqlConnect.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employeeTransaction")
public class EmployeeTransactionalController {

    @Autowired
    private EmployeeService empService;

    @PostMapping("/save/required")
    public String saveRequired(@RequestBody Employee emp) {
        empService.saveEmployeeWithRequired(emp);
        return "Saved using REQUIRED";
    }

    @PostMapping("/save/requiresNew")
    public String saveRequiresNew(@RequestBody Employee emp) {
        empService.saveEmployeeWithRequiresNew(emp);
        return "Saved using REQUIRES_NEW";
    }

    @PostMapping("/save/nested")
    public String saveNested(@RequestBody Employee emp) {
        empService.saveEmployeeWithNested(emp);
        return "Saved using NESTED";
    }

    @PostMapping("/save/mandatory")
    public String saveMandatory(@RequestBody Employee emp) {
        empService.saveEmployeeWithMandatory(emp);
        return "Saved using MANDATORY";
    }

    @PostMapping("/save/mandatory-fail")
    public String saveMandatoryFail(@RequestBody Employee emp) {
        empService.saveEmployeeWithMandatory_throws(emp);
        return "This will fail if no TX exists";
    }
}
