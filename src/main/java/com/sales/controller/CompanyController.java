package com.sales.controller;

import com.sales.dto.CompanyDTO;
import com.sales.service.CompanyService;
import com.sales.service.converter.CompanyConverter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    private CompanyService companyService;
    private CompanyConverter converter;

    public CompanyController(CompanyService companyService, CompanyConverter converter) {
        this.companyService = companyService;
        this.converter = converter;
    }

    @GetMapping("/all")
    public List<CompanyDTO> getAllCompanies() {
        return converter.convertListToDto(companyService.getAllCompany());
    }

    @GetMapping("/{id}")
    public CompanyDTO getCompanyById(@PathVariable("id") int id) {
        return converter.convertToDto(companyService.getCompany(id));
    }

    @PostMapping("/")
    public void createCompany(@RequestBody CompanyDTO companyDTO) {
        companyService.addCompany(converter.convertToEntity(companyDTO));
    }

    @PutMapping("/")
    public void updateCompany(@RequestBody CompanyDTO companyDTO) {
        companyService.updateCompany(converter.convertToEntity(companyDTO));
    }

    @DeleteMapping("/{id}")
    public void deleteCompany(@PathVariable("id") int id) {
        companyService.deleteCompany(id);
    }

}
