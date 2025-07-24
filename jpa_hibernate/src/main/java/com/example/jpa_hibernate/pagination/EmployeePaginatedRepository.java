package com.example.jpa_hibernate.pagination;

import com.example.jpa_hibernate.MySqlConnect.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeePaginatedRepository extends JpaRepository<Employee, Long> {
    Page<Employee> findAll(Pageable pageable);
}
