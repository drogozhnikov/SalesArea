package com.sales.repository;

import com.sales.entity.Category;
import com.sales.entity.Company;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class CategoryDaoImpl implements CategoryDao {

    private SessionFactory sessionFactory;

    public CategoryDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List getAllCategory() {
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("from Category ").list();
    }

    @Override
    public Category getCategory(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.get(Category.class, id);
    }

    @Override
    public Category addCategory(Category category) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(category);
        return category;
    }

    @Override
    public void updateCategory(Category category) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(category);
    }

    @Override
    public void deleteCategory(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Category category = session.load(Category.class, id);
        Optional<Category> optCategory = Optional.ofNullable(category);
        if(!optCategory.isPresent()){
            session.delete(category);
        }
    }
}
