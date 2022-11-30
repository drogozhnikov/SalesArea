package com.sales.repository;

import com.sales.entity.User;

import java.util.List;

public interface UserDao {

    public List<User> getAllUsers();

    public User getUser(int id);

    public User addUser(User user);

    public void updateUser(User user);

    public void deleteUser(int id);
}
