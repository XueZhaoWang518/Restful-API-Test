package com.example.restservice.company;

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

    @GetMapping("/companies/page/{page}/pageSize/{pageSize}")
    public List<Company> getCompanies(@PathVariable int page, @PathVariable int pageSize) {
        List<Company> res = new ArrayList<>();
        List<Company> companyList = companyRepository.getCompanyList();
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


    @PutMapping("/companies/{companyId}")
    public void updateCompanies(@PathVariable Long companyId, @RequestBody Company company) {
        companyRepository.updateCompany(companyId, company);
    }
}


