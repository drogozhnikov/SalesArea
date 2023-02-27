package com.sales.repository;

import com.sales.entity.UserEntity;
import org.apache.catalina.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;

    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public Optional<UserEntity> findByUserName(String userName){
        Session session = this.sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(UserEntity.class);
        criteria.add(Restrictions.eq("username", userName));
        UserEntity entity = (UserEntity) criteria.list().get(0);
        return Optional.of(entity);
    }

    @Override
    public List getAllUsers() {
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("from UserEntity").list();
    }

    @Override
    public UserEntity getUser(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.get(UserEntity.class, id);
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
