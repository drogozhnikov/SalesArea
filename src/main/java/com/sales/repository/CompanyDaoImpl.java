package com.sales.repository;

import com.sales.entity.CompanyEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CompanyDaoImpl implements CompanyDao {

    private SessionFactory sessionFactory;

    public CompanyDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List getAllCompany() {
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("from CompanyEntity ").list();
    }

    @Override
    public CompanyEntity getCompany(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.get(CompanyEntity.class, id);
    }

    @Override
    public CompanyEntity addCompany(CompanyEntity companyEntity) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(companyEntity);
        return companyEntity;
    }

    @Override
    public void updateCompany(CompanyEntity companyEntity) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(companyEntity);
    }

    @Override
    public void deleteCompany(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        CompanyEntity companyEntity = session.load(CompanyEntity.class, id);
        Optional<CompanyEntity> optCompany = Optional.ofNullable(companyEntity);
        if(!optCompany.isPresent()){
            session.delete(companyEntity);
        }
    }
}
