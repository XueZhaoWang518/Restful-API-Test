package com.example.restservice.company;

import com.example.restservice.employee.Employee;
import com.example.restservice.employee.EmployeeService;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Repository
public class CompanyRepository {

    public static List<Company> companyList = new ArrayList<>();

    public List<Company> getCompanyList() {
        return companyList;
    }

    public Company getCompanyById(Long id) {
        return companyList.stream().filter(item -> item.getCompanyId() == id).findFirst().map(item -> item).orElse(null);
    }

    public void addCompany(Company company) {
        companyList.add(company);
    }

    public void updateCompany(Long id, Company company) {
        companyList.forEach(item -> {
            if (item.getCompanyId() == id) {
                item.setCompanyId(company.getCompanyId());
                item.setCompanyName(company.getCompanyName());
                item.setEmployeesNumber(company.getEmployeesNumber());
                item.setEmployees(company.getEmployees());
            }
        });
    }
}
