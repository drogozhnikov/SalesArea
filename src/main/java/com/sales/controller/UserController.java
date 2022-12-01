package com.sales.controller;

import com.sales.entity.UserEntity;
import com.sales.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable("id") int id) {
        return userService.getUser(id);
    }

    @PostMapping("/")
    public void createUser(@RequestBody UserEntity userEntity) {
        userService.addUser(userEntity);
    }

    @PutMapping("/")
    public void updateUser(@RequestBody UserEntity userEntity) {
        userService.updateUser(userEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
    }
}
