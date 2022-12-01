package com.sales.controller;

import com.sales.entity.CompanyEntity;
import com.sales.service.CompanyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/all")
    public List<CompanyEntity> getAllCompanies() {
        return companyService.getAllCompany();
    }

    @GetMapping("/{id}")
    public CompanyEntity getCompanyById(@PathVariable("id") int id) {
        return companyService.getCompany(id);
    }

    @PostMapping("/")
    public void createCompany(@RequestBody CompanyEntity companyEntity) {
        companyService.addCompany(companyEntity);
    }

    @PutMapping("/")
    public void updateCompany(@RequestBody CompanyEntity companyEntity) {
        companyService.updateCompany(companyEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteCompany(@PathVariable("id") int id) {
        companyService.deleteCompany(id);
    }
}
