package com.sales.repository;

import com.sales.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;

    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List getAllUsers() {
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("from UserEntity").list();
    }

    @Override
    public UserEntity getUser(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        return (UserEntity) session.get(UserEntity.class, id);
    }

    @Override
    public UserEntity addUser(UserEntity userEntity) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(userEntity);
        return userEntity;
    }

    @Override
    public void updateUser(UserEntity userEntity) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(userEntity);
    }

    @Override
    public void deleteUser(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        UserEntity userEntity = session.load(UserEntity.class, id);
        Optional<UserEntity> optUser = Optional.ofNullable(userEntity);
        if(!optUser.isPresent()){
            session.delete(userEntity);
        }
    }

}
