package com.example.restservice.controller;

import com.example.restservice.service.model.Company;
import com.example.restservice.repository.CompanyRepository;
import com.example.restservice.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CompanyController {

    @Autowired
    private CompanyService companyService;
    @Autowired
    private CompanyRepository companyRepository;


    @GetMapping("/companies")
    public List<Company> companies() {
        return companyRepository.getCompanyList();
    }

    @GetMapping("/companies/{companyId}")
    public Company getCompanyById(@PathVariable Long companyId) {
        return companyRepository.getCompanyById(companyId);
    }

    @PostMapping("/companies")
    public void addCompany(@RequestBody Company company) {
        companyRepository.addCompany(company);
    }

    @GetMapping("/companies?page={page}&size={pageSize}")
    public List<Company> getCompanies(@PathVariable int page, @PathVariable int pageSize) {
        return companyRepository.getCompanies(page, pageSize);
    }


    @PutMapping("/companies/{companyId}")
    public void updateCompanies(@PathVariable Long companyId, @RequestBody Company company) {
        companyRepository.updateCompany(companyId, company);
    }
}


