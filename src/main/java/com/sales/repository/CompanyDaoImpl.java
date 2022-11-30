package com.sales.repository;

import com.sales.entity.Company;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class CompanyDaoImpl implements CompanyDao {

    private SessionFactory sessionFactory;

    public CompanyDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List getAllCompany() {
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("from Company ").list();
    }

    @Override
    public Company getCompany(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.get(Company.class, id);
    }

    @Override
    public Company addCompany(Company company) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(company);
        return company;
    }

    @Override
    public void updateCompany(Company company) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(company);
    }

    @Override
    public void deleteCompany(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Company company = session.load(Company.class, id);
        Optional<Company> optCompany = Optional.ofNullable(company);
        if(!optCompany.isPresent()){
            session.delete(company);
        }
    }
}
