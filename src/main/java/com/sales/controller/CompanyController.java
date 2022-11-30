package com.sales.controller;

import com.sales.entity.Company;
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
    public List<Company> getAllUsers() {
        return companyService.getAllCompany();
    }

    @GetMapping("/{id}")
    public Company getUserById(@PathVariable("id") int id) {
        return companyService.getCompany(id);
    }

    @PostMapping("/")
    public void createUser(@RequestBody Company company) {
        companyService.addCompany(company);
    }

    @PutMapping("/")
    public void updateUser(@RequestBody Company company) {
        companyService.updateCompany(company);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        companyService.deleteCompany(id);
    }
}
