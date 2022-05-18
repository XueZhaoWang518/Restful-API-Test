package com.example.restservice;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class EmployeeService {
    protected static Employee employee1 = new Employee(1, "alibaba1", 20, "male", 6000);
    protected static Employee employee2 = new Employee(11, "alibaba2", 19, "female", 7000);
    protected static Employee employee3 = new Employee(6, "alibaba3", 27, "male", 8000);
    protected static Employee employee4 = new Employee(13, "alibaba4", 23, "female", 6000);

    public static List<Employee> employeeList = new ArrayList<>();

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public static void setEmployeeList(List<Employee> employeeList) {
        EmployeeService.employeeList = employeeList;
    }

    public void setCompanyList() {
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        employeeList.add(employee4);
    }

    public EmployeeService() {
        this.setCompanyList();
    }
    public Employee getEmployeeById(int id) {
        AtomicReference<Employee> res = new AtomicReference<>();
        employeeList.forEach(item->{
            if (item.getId() == id) {
                res.set(item);
            }
        });
        return res.get();
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void updateEmployee(int id, Employee employee) {
        employeeList.forEach(item -> {
            if (item.getId() == id) {
                item.setId(employee.getId());
                item.setName(employee.getName());
                item.setAge(employee.getAge());
                item.setGender(employee.getGender());
                item.setSalary(employee.getSalary());
            }
        });
    }
}
