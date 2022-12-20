package com.sales.service;

import com.sales.entity.UserEntity;
import com.sales.repository.UserDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class UserService {

    private UserDao userDao;
    private MessageService messageService;

    public UserService(UserDao userDao, MessageService messageService) {
        this.userDao = userDao;
        this.messageService = messageService;
    }

    @Transactional
    public List<UserEntity> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Transactional
    public UserEntity getUser(int id) {
        return userDao.getUser(id);
    }

    @Transactional
    public void addUser(UserEntity userEntity) {
        userDao.addUser(userEntity);
    }

    @Transactional
    public void updateUser(UserEntity userEntity) {
        userDao.updateUser(userEntity);
    }

    @Transactional
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

}
