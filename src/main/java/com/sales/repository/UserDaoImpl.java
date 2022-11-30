package com.sales.repository;

import com.sales.entity.User;
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
        return session.createQuery("from User").list();
    }

    @Override
    public User getUser(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        return (User) session.get(User.class, id);
    }

    @Override
    public User addUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(user);
        return user;
    }

    @Override
    public void updateUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
    }

    @Override
    public void deleteUser(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = session.load(User.class, id);
        Optional<User> optUser = Optional.ofNullable(user);
        if(!optUser.isPresent()){
            session.delete(user);
        }
    }

}
