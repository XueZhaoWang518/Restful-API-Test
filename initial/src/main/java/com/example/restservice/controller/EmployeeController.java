package com.example.restservice.controller;

import com.example.restservice.service.model.Employee;
import com.example.restservice.repository.EmployeeRepository;
import com.example.restservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public List<Employee> employees() {
        return employeeRepository.getEmployeeList();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getCompanyById(@PathVariable int employeeId) {
        return employeeRepository.getEmployeeById(employeeId);
    }

    @PostMapping("/employees")
    public void addCompany(@RequestBody Employee employee) {
        employeeRepository.addEmployee(employee);
    }

    @PutMapping("/employees/{employeeId}")
    public void updateCompanies(@PathVariable int employeeId, @RequestBody Employee employee) {
        employeeRepository.updateEmployee(employeeId, employee);
    }
}


