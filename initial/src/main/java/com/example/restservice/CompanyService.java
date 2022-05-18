package com.example.restservice;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import com.example.restservice.EmployeeService;


@Service
public class CompanyService {
    /*
    @Repository
    private CompanyRepository companyRepository;
    */

    private static int companyId1 = 1;
    private static String companyName1 = "alibaba";
    private static int employeesNumber1 = 200;

    private static Employee[] employees1 = {EmployeeService.employee1, EmployeeService.employee2, EmployeeService.employee3, EmployeeService.employee4};

    private static Company company1 = new Company(companyId1, companyName1, employeesNumber1, employees1);

    private static int companyId2 = 2;
    private static String companyName2 = "tengxun";
    private static int employeesNumber2 = 300;
    private static Employee employee5 = new Employee(1, "tengxun1", 20, "male", 6000);
    private static Employee employee6 = new Employee(11, "tengxun2", 19, "female", 7000);
    private static Employee[] employees2 = {employee5, employee6};
    private static Company company2 = new Company(companyId2, companyName2, employeesNumber2, employees2);
    public static List<Company> companyList = new ArrayList<>();

    public List<Company> getCompanyList() {
        return companyList;
    }

    public void setCompanyList() {
        companyList.add(company1);
        companyList.add(company2);
    }

    public CompanyService() {
        this.setCompanyList();
    }
    public Company getCompanyById(int id) {
        AtomicReference<Company> res = new AtomicReference<>();
       companyList.forEach(item->{
           if (item.getCompanyId() == id) {
               res.set(item);
           }
       });
        return res.get();
    }

    public void addCompany(Company company) {
        companyList.add(company);
    }

    public void updateCompany(int id, Company company) {
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
