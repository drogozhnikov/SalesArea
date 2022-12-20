package com.sales.controller;

import com.sales.dto.CompanyDTO;
import com.sales.entity.CompanyEntity;
import com.sales.service.CompanyService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    private CompanyService companyService;
    private ModelMapper modelMapper;

    public CompanyController(CompanyService companyService, ModelMapper modelMapper) {
        this.companyService = companyService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/all")
    public List<CompanyDTO> getAllCompanies() {
        List<CompanyEntity> entitiesList = companyService.getAllCompany();
        return entitiesList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public CompanyDTO getCompanyById(@PathVariable("id") int id) {
        return convertToDto(companyService.getCompany(id));
    }

    @PostMapping("/")
    public void createCompany(@RequestBody CompanyDTO companyDTO) {
        companyService.addCompany(convertToEntity(companyDTO));
    }

    @PutMapping("/")
    public void updateCompany(@RequestBody CompanyDTO companyDTO) {
        companyService.updateCompany(convertToEntity(companyDTO));
    }

    @DeleteMapping("/{id}")
    public void deleteCompany(@PathVariable("id") int id) {
        companyService.deleteCompany(id);
    }


    private CompanyDTO convertToDto(CompanyEntity inputEntity) {
        return modelMapper.map(inputEntity, CompanyDTO.class);
    }

    private CompanyEntity convertToEntity(CompanyDTO inputDTO) {
        return modelMapper.map(inputDTO, CompanyEntity.class);
    }
}
