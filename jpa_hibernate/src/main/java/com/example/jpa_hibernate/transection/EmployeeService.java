package com.example.jpa_hibernate.transection;

import com.example.jpa_hibernate.MySqlConnect.Employee;
import com.example.jpa_hibernate.MySqlConnect.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepo;
    @Autowired
    private DepartmentService deptService;
    @Autowired
    private AddressService addressService;

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveEmployeeWithRequired(Employee emp) {
        employeeRepo.save(emp);
        deptService.saveWithRequired(emp.getDepartment());
        addressService.saveWithRequired(emp.getAddress());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveEmployeeWithRequiresNew(Employee emp) {
        employeeRepo.save(emp);
        deptService.saveWithRequiresNew(emp.getDepartment());
        addressService.saveWithRequiresNew(emp.getAddress());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveEmployeeWithNested(Employee emp) {
        employeeRepo.save(emp);
        deptService.saveWithNested(emp.getDepartment());
        addressService.saveWithNested(emp.getAddress());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveEmployeeWithMandatory(Employee emp) {
        deptService.saveWithMandatory(emp.getDepartment());
    }

    public void saveEmployeeWithMandatory_throws(Employee emp) {
        deptService.saveWithMandatory(emp.getDepartment());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveEmployeeWithSupports(Employee emp) {
        employeeRepo.save(emp);
        deptService.saveWithSupports(emp.getDepartment());
        addressService.saveWithSupports(emp.getAddress());
    }

    public void saveEmployeeWithSupports_noTx(Employee emp) {
        deptService.saveWithSupports(emp.getDepartment());
        addressService.saveWithSupports(emp.getAddress());
    }

    public void saveEmployeeWithNever(Employee emp) {
        deptService.saveWithNever(emp.getDepartment());
        addressService.saveWithNever(emp.getAddress());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveEmployeeWithNever_throws(Employee emp) {
        deptService.saveWithNever(emp.getDepartment());
        addressService.saveWithNever(emp.getAddress());
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void saveEmployeeWithNotSupported(Employee emp) {
        employeeRepo.save(emp);
        deptService.saveWithNotSupported(emp.getDepartment());
        addressService.saveWithNotSupported(emp.getAddress());
    }

    public void saveEmployeeWithSupportsNoTx(Employee emp) {
        deptService.saveWithSupports(emp.getDepartment());
        addressService.saveWithSupports(emp.getAddress());
    }

    public void saveEmployeeWithNeverInsideTx(Employee emp) {
        saveEmployeeWithNever_throws(emp);
    }

    public void saveEmployeeWithMandatoryNoTx(Employee emp) {
        saveEmployeeWithMandatory_throws(emp);
    }
}
