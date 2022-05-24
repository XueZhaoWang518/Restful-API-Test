package com.example.restservice.service;

import com.example.restservice.service.model.Company;
import org.springframework.stereotype.Service;
import com.example.restservice.repository.CompanyRepository;

@Service
public class CompanyService {
    CompanyRepository companyRepository;

    public CompanyService() {
    }

    public void updateCompany(Long id, Company company) {
        int index;
        index = companyRepository.findCompanyById(id);
        Company iniCompany = companyRepository.getCompanyList().get(index);
        companyRepository.updateCompany(iniCompany,company);
        companyRepository.saveCompany(index, iniCompany);
    }





}
