package com.example.restservice.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/employees")
    public List<Employee> employees() {
        return employeeService.getEmployeeList();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getCompanyById(@PathVariable int employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    @PostMapping("/employees")
    public void addCompany(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

    @PutMapping("/employees/{employeeId}")
    public void updateCompanies(@PathVariable int employeeId, @RequestBody Employee employee) {
        employeeService.updateEmployee(employeeId, employee);
    }
}


