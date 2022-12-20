package com.sales.repository;

import com.sales.entity.CompanyEntity;

import java.util.List;

public interface CompanyDao {

    public List<CompanyEntity> getAllCompany();

    public CompanyEntity getCompany(int id);

    public CompanyEntity addCompany(CompanyEntity companyEntity);

    public void updateCompany(CompanyEntity companyEntity);

    public void deleteCompany(int id);
}
