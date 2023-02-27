package com.sales.repository;

import com.sales.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    Optional<UserEntity> findByUserName(String userName);

    public List<UserEntity> getAllUsers();

    public UserEntity getUser(int id);

    public UserEntity addUser(UserEntity userEntity);

    public void updateUser(UserEntity userEntity);

    public void deleteUser(int id);
}
