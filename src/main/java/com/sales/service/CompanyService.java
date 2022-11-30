package com.sales.service;

import com.sales.entity.Company;
import com.sales.repository.CompanyDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class CompanyService {

    private CompanyDao companyDao;
    private MessageService messageService;

    public CompanyService(CompanyDao companyDao, MessageService messageService) {
        this.companyDao = companyDao;
        this.messageService = messageService;
    }

    @Transactional
    public List<Company> getAllCompany() {
        return companyDao.getAllCompany();
    }

    @Transactional
    public Company getCompany(int id) {
        return companyDao.getCompany(id);
    }

    @Transactional
    public void addCompany(Company company) {
        companyDao.addCompany(company);
    }

    @Transactional
    public void updateCompany(Company company) {
        companyDao.updateCompany(company);
    }

    @Transactional
    public void deleteCompany(int id) {
        companyDao.deleteCompany(id);
    }
}
