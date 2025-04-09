package com.wecp.empwellbeingapplication.controller;


import com.wecp.empwellbeingapplication.entity.Employee;
import com.wecp.empwellbeingapplication.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {


   @Autowired
    private EmployeeService employeeService;
    

@PostMapping
    public Employee registerEmployee(@RequestBody Employee employee) {
       // register employee
       return employeeService.registerEmployee(employee);
    }
@DeleteMapping("/{employeeId}")
    public void deleteEmployee(@PathVariable Long employeeId) {
       // delete employee
       employeeService.deleteEmployee(employeeId);
    }


    @GetMapping
    public List<Employee> getAllEmployees() {
      // get all employees
      return employeeService.getAllEmployees();
    }

}
