package com.sales.service;

import com.sales.entity.User;
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
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Transactional
    public User getUser(int id) {
        return userDao.getUser(id);
    }

    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Transactional
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Transactional
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

}
