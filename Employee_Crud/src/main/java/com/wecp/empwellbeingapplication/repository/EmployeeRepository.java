package com.wecp.empwellbeingapplication.repository;


import com.wecp.empwellbeingapplication.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EmployeeRepository extends JpaRepository<Employee,Long>  {
    // extends jpa repository
}