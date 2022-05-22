package com.example.restservice.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {

    @Autowired
    private CompanyService companyService;


    @GetMapping("/companies")
    public List<Company> companies() {

        return companyService.getCompanyList();
    }

    @GetMapping("/companies/{companyId}")
    public Company getCompanyById(@PathVariable int companyId) {
        return companyService.getCompanyById(companyId);
    }

    @PostMapping("/companies")
    public void addCompany(@RequestBody Company company) {
        companyService.addCompany(company);
    }
/*
    @GetMapping("/companies/page/{page}/pageSize/{pageSize}")
    public void getCompanies(@PathVariable int page, @PathVariable int pageSize) {
        companyRepository.find(page, size);
    }

 */

    @PutMapping("/companies/{companyId}")
    public void updateCompanies(@PathVariable int companyId, @RequestBody Company company) {
        companyService.updateCompany(companyId, company);
    }
}


