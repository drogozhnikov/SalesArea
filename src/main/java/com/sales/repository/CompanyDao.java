package com.sales.repository;

import com.sales.entity.Company;

import java.util.List;

public interface CompanyDao {

    public List<Company> getAllCompany();

    public Company getCompany(int id);

    public Company addCompany(Company company);

    public void updateCompany(Company company);

    public void deleteCompany(int id);
}
