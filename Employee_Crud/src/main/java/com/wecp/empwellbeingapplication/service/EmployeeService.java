package com.wecp.empwellbeingapplication.service;


import com.wecp.empwellbeingapplication.entity.Employee;
import com.wecp.empwellbeingapplication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee registerEmployee(Employee employee) {
       // register employee
       return employeeRepository.save(employee);

    }

    public void deleteEmployee(Long employeeId) {
      // delete employee
       employeeRepository.deleteById(employeeId);
    }

    public List<Employee> getAllEmployees() {
       // get all employees
       return employeeRepository.findAll();
    }
}