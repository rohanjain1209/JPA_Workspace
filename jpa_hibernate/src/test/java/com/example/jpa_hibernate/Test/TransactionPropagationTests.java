package com.example.jpa_hibernate.Test;


import com.example.jpa_hibernate.MySqlConnect.Address;
import com.example.jpa_hibernate.MySqlConnect.Department;
import com.example.jpa_hibernate.MySqlConnect.Employee;
import com.example.jpa_hibernate.transection.EmployeeService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.TransactionSystemException;

import java.math.BigDecimal;

@SpringBootTest
public class TransactionPropagationTests {

    @Autowired
    private EmployeeService employeeService;

    private Employee getSampleEmployee(String deptName, String street) {
        Employee emp = new Employee();
        emp.setFirstName("John");
        emp.setLastName("Doe");
        emp.setSalary(BigDecimal.valueOf(50000.00));
        emp.setRole("Engineer");

        Department dept = new Department();
        dept.setDepartmentName(deptName);
        emp.setDepartment(dept);

        Address address = new Address();
        address.setStreet(street);
        address.setCity("Mumbai");
        address.setState("MH");
        address.setZipcode("400001");
        emp.setAddress(address);

        return emp;
    }

 /*   @Test
    void testRequiredPropagation_Success() {
        Employee emp = getSampleEmployee("Engineering", "MG Road");
        employeeService.saveEmployeeWithRequired(emp);
    }

    @Test
    void testRequiredPropagation_Failure() {
        Employee emp = getSampleEmployee("FAIL", "MG Road");
        Assertions.assertThrows(RuntimeException.class, () ->
            employeeService.saveEmployeeWithRequired(emp));
    }

    @Test
    void testRequiresNewPropagation_Success() {
        Employee emp = getSampleEmployee("Engineering", "Linking Road");
        employeeService.saveEmployeeWithRequiresNew(emp);
    }

    @Test
    void testRequiresNewPropagation_DepartmentFails_AddressSucceeds() {
        Employee emp = getSampleEmployee("FAIL", "Linking Road");
        Assertions.assertThrows(RuntimeException.class, () ->
            employeeService.saveEmployeeWithRequiresNew(emp));
    }

    @Test
    void testNestedPropagation_Success() {
        Employee emp = getSampleEmployee("Support", "Churchgate");
        employeeService.saveEmployeeWithNested(emp);
    }

    @Test
    void testNestedPropagation_Failure() {
        Employee emp = getSampleEmployee("FAIL", "Churchgate");
        Assertions.assertThrows(RuntimeException.class, () ->
            employeeService.saveEmployeeWithNested(emp));
    }

    @Test
    void testMandatoryPropagation_WithoutOuterTx() {
        Employee emp = getSampleEmployee("Legal", "Marine Drive");
        Assertions.assertThrows(TransactionSystemException.class, () ->
            employeeService.saveEmployeeWithMandatoryNoTx(emp));
    }

    @Test
    void testNeverPropagation_WithOuterTx() {
        Employee emp = getSampleEmployee("Engineering", "Bandra");
        Assertions.assertThrows(IllegalStateException.class, () ->
            employeeService.saveEmployeeWithNeverInsideTx(emp));
    }

    @Test
    void testSupportsPropagation_NoOuterTx() {
        Employee emp = getSampleEmployee("Support", "Worli");
        employeeService.saveEmployeeWithSupportsNoTx(emp);
    }

    @Test
    void testNotSupportedPropagation_WithOuterTx() {
        Employee emp = getSampleEmployee("Engineering", "Andheri");
        employeeService.saveEmployeeWithNotSupported(emp);
    }*/
}
