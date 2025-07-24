package com.example.jpa_hibernate.transection;

import com.example.jpa_hibernate.MySqlConnect.Department;
import com.example.jpa_hibernate.MySqlConnect.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository deptRepo;

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveWithRequired(Department dept) {
        deptRepo.save(dept);
        if ("FAIL".equals(dept.getDepartmentName())) {
            throw new RuntimeException("Forced failure in department");
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveWithRequiresNew(Department dept) {
        deptRepo.save(dept);
        if ("FAIL".equals(dept.getDepartmentName())) {
            throw new RuntimeException("Forced failure in department");
        }
    }

    @Transactional(propagation = Propagation.NESTED)
    public void saveWithNested(Department dept) {
        deptRepo.save(dept);
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void saveWithMandatory(Department dept) {
        deptRepo.save(dept);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void saveWithSupports(Department dept) {
        deptRepo.save(dept);
    }

    @Transactional(propagation = Propagation.NEVER)
    public void saveWithNever(Department dept) {
        deptRepo.save(dept);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void saveWithNotSupported(Department dept) {
        deptRepo.save(dept);
    }

}
