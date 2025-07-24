package com.example.jpa_hibernate.Hibernate;

import com.example.jpa_hibernate.MySqlConnect.Department;
import com.example.jpa_hibernate.MySqlConnect.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
public class EmployeeHibernateService {

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    HibernateUtil util;


    @Transactional
    public void saveWithHibernate(Employee emp) {
        Session session = entityManager.unwrap(Session.class);

        // 🔍 Check if department exists by name
        String deptName = emp.getDepartment().getDepartmentName();

        Department existingDept = session
                .createQuery("FROM Department WHERE departmentName = :deptName", Department.class)
                .setParameter("deptName", deptName)
                .uniqueResult();

        if (existingDept != null) {
            emp.setDepartment(existingDept); // use existing
        } else {
            session.save(emp.getDepartment()); // save new
        }

        session.save(emp.getAddress());
        session.save(emp);
    }
    public void saveWithHibernateManualTransaction(Employee emp) {
        SessionFactory sessionFactory =util.getSessionFactory();
        Session session = null;
        Transaction tx = null;

        try {
            session = sessionFactory.openSession(); //  open new session
            tx = session.beginTransaction();        //  begin transaction

            // 🔍 Check if department exists
            String deptName = emp.getDepartment().getDepartmentName();
            Department existingDept = session
                    .createQuery("FROM Department WHERE departmentName = :deptName", Department.class)
                    .setParameter("deptName", deptName)
                    .uniqueResult();

            if (existingDept != null) {
                emp.setDepartment(existingDept);
            } else {
                session.save(emp.getDepartment());
            }

            session.save(emp.getAddress());
            session.save(emp);

            tx.commit();
        } catch (Exception ex) {
            if (tx != null) tx.rollback(); //  rollback on error
            throw new RuntimeException("Transaction failed: " + ex.getMessage(), ex);
        } finally {
            if (session != null) session.close(); // 🧹 cleanup
        }
    }


    public List<Object[]> findEmployeesByCriteria() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = cb.createQuery(Object[].class);

        Root<Employee> employee = query.from(Employee.class);
        Join<Object, Object> dept = employee.join("department");

        // SELECT e.firstName, e.lastName, e.salary
        query.multiselect(
                employee.get("firstName"),
                employee.get("lastName"),
                employee.get("salary")
        );

        // WHERE e.salary > 40000 AND dept.departmentName = 'Engineering'
        Predicate salaryGreater = cb.gt(employee.get("salary"), BigDecimal.valueOf(40000));
        Predicate deptNameEquals = cb.equal(dept.get("departmentName"), "Engineering");

        query.where(cb.and(salaryGreater, deptNameEquals));

        return entityManager.createQuery(query).getResultList();

    }

    public List<Object[]> getDepartmentWiseSalaryStats() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = cb.createQuery(Object[].class);

        Root<Employee> emp = query.from(Employee.class);
        Join<Employee, Department> dept = emp.join("department");

        // SELECT dept.departmentName, COUNT(emp), SUM(emp.salary)
        query.multiselect(
                dept.get("departmentName"),
                cb.count(emp),
                cb.sum(emp.get("salary"))
        );

        // GROUP BY dept.departmentName
        query.groupBy(dept.get("departmentName"));

        return entityManager.createQuery(query).getResultList();
    }
}

