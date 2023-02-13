package com.sales.controller;

import com.sales.dto.CompanyDTO;
import com.sales.service.CompanyService;
import com.sales.service.converter.CompanyConverter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @PreAuthorize("hasAuthority('developers:read')")
    public List<CompanyDTO> getAllCompanies() {
        return converter.convertListToDto(companyService.getAllCompany());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('developers:read')")
    public CompanyDTO getCompanyById(@PathVariable("id") int id) {
        return converter.convertToDto(companyService.getCompany(id));
    }

    @PostMapping("/")
    @PreAuthorize("hasAuthority('developers:write')")
    public void createCompany(@RequestBody CompanyDTO companyDTO) {
        companyService.addCompany(converter.convertToEntity(companyDTO));
    }

    @PutMapping("/")
    @PreAuthorize("hasAuthority('developers:write')")
    public void updateCompany(@RequestBody CompanyDTO companyDTO) {
        companyService.updateCompany(converter.convertToEntity(companyDTO));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('developers:write')")
    public void deleteCompany(@PathVariable("id") int id) {
        companyService.deleteCompany(id);
    }

}
