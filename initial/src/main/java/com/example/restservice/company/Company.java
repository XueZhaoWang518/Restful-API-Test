package com.example.restservice.company;

import com.example.restservice.employee.Employee;

public class Company<companyId> {
    private Long companyId;
    private String companyName;
    private int employeesNumber;
    private Employee[] employees;

    public Company(Long companyId, String companyName, int employeesNumber, Employee[] employees) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.employeesNumber = employeesNumber;
        this.employees = employees;
    }

    public  Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Employee[] getEmployees() {
        if (this.employees == null) {
            this.employees = new Employee[200];
        }
        return employees;
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }

    public int getEmployeesNumber() {
        return employeesNumber;
    }

    public void setEmployeesNumber(int employeesNumber) {
        this.employeesNumber = employeesNumber;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
