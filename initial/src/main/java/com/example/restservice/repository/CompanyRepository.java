package com.example.restservice.repository;

import com.example.restservice.service.model.Company;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CompanyRepository {

    public static List<Company> companyList = new ArrayList<>();

    public List<Company> getCompanyList() {
        return companyList;
    }

    public Company getCompanyById(Long id) {
        return companyList.stream().filter(item -> item.getCompanyId().equals (id)).findFirst().orElse(null);
    }

    public void addCompany(Company company) {
        companyList.add(company);
    }


    public int findCompanyById(Long id){
        return companyList.indexOf(companyList.stream().filter(item -> item.getCompanyId().equals(id)).findFirst().orElse(null));
    }

    public void updateCompany(Company iniCompany, Company newCompany) {
        if (newCompany != null) {
            iniCompany.setCompanyId(newCompany.getCompanyId());
            iniCompany.setCompanyName(newCompany.getCompanyName());
            iniCompany.setEmployees(newCompany.getEmployees());
            iniCompany.setCompanyName(newCompany.getCompanyName());
            iniCompany.setEmployeesNumber(newCompany.getEmployeesNumber());
        }
    }

    public void saveCompany(int index, Company newCompany) {
        companyList.set(index, newCompany);
    }

    public List<Company> getCompanies(int page, int pageSize) {
        List<Company> res = new ArrayList<>();
        List<Company> companyList = getCompanyList();
        int size = companyList.size();
        int m = size / pageSize;
        if ((m+1) >= pageSize) {
            int initialPage = pageSize * (page - 1);
            for (int i = 0; i < pageSize; i++) {
                res.add(companyList.get(initialPage + i));
            }
        }
        return res;
    }
}
