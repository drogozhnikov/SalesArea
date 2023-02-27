package com.sales.service;

import com.sales.entity.UserEntity;
import com.sales.repository.UserDao;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class UserService {

    private UserDao userDao;
    private MessageService messageService;

    public UserService(UserDao userDao, MessageService messageService) {
        this.userDao = userDao;
        this.messageService = messageService;
    }

    public UserEntity findByUserName(String username){
        return userDao.findByUserName(username).get();
    }

    public List<UserEntity> getAllUsers() {
        return userDao.getAllUsers();
    }

    public UserEntity getUser(int id) {
        return userDao.getUser(id);
    }

    public void addUser(UserEntity userEntity) {
        userDao.addUser(userEntity);
    }

    public void updateUser(UserEntity userEntity) {
        userDao.updateUser(userEntity);
    }

    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

}
