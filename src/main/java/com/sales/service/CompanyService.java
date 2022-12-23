package com.sales.service;

import com.sales.entity.CompanyEntity;
import com.sales.repository.CompanyDao;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class CompanyService {

    private CompanyDao companyDao;
    private MessageService messageService;

    public CompanyService(CompanyDao companyDao, MessageService messageService) {
        this.companyDao = companyDao;
        this.messageService = messageService;
    }

    @Transactional
    public List<CompanyEntity> getAllCompany() {
        return companyDao.getAllCompany();
    }

    @Transactional
    public CompanyEntity getCompany(int id) {
        return companyDao.getCompany(id);
    }

    @Transactional
    public void addCompany(CompanyEntity companyEntity) {
        companyDao.addCompany(companyEntity);
    }

    @Transactional
    public void updateCompany(CompanyEntity companyEntity) {
        companyDao.updateCompany(companyEntity);
    }

    @Transactional
    public void deleteCompany(int id) {
        companyDao.deleteCompany(id);
    }
}
