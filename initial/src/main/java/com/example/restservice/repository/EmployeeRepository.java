package com.example.restservice.repository;

import com.example.restservice.service.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Repository
public class EmployeeRepository {


    public static List<Employee> employeeList = new ArrayList<>();

    public List<Employee> getEmployeeList() {
        return employeeList;
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
    public Employee getEmployeeById(int id) {
        AtomicReference<Employee> res = new AtomicReference<>();
        employeeList.forEach(item->{
            if (item.getId() == id) {
                res.set(item);
            }
        });
        return res.get();
    }
}
