package com.sales.repository;

import com.sales.entity.CategoryEntity;
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
        return session.createQuery("from CategoryEntity ").list();
    }

    @Override
    public CategoryEntity getCategory(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.get(CategoryEntity.class, id);
    }

    @Override
    public CategoryEntity addCategory(CategoryEntity categoryEntity) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(categoryEntity);
        return categoryEntity;
    }

    @Override
    public void updateCategory(CategoryEntity categoryEntity) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(categoryEntity);
    }

    @Override
    public void deleteCategory(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        CategoryEntity categoryEntity = session.load(CategoryEntity.class, id);
        Optional<CategoryEntity> optCategory = Optional.ofNullable(categoryEntity);
        if(!optCategory.isPresent()){
            session.delete(categoryEntity);
        }
    }
}
