package com.sales.repository;

import com.sales.entity.UserEntity;

import java.util.List;

public interface UserDao {

    public List<UserEntity> getAllUsers();

    public UserEntity getUser(int id);

    public UserEntity addUser(UserEntity userEntity);

    public void updateUser(UserEntity userEntity);

    public void deleteUser(int id);
}
