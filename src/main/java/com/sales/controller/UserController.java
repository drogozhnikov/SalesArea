package com.sales.controller;

import com.sales.dto.UserDTO;
import com.sales.service.UserService;
import com.sales.service.converter.UserConverter;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;
    private UserConverter converter;

    public UserController(UserService userService, UserConverter converter) {
        this.userService = userService;
        this.converter = converter;
    }

    @GetMapping("/all")
    public List<UserDTO> getAllUsers() {
        return converter.convertListToDto(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable("id") int id) {
        return converter.convertToDto(userService.getUser(id));
    }

    @PostMapping("/")
    public void createUser(@RequestBody UserDTO userDTO) {
        userService.addUser(converter.convertToEntity(userDTO));
    }

    @PutMapping("/")
    public void updateUser(@RequestBody UserDTO userDTO) {
        userService.updateUser(converter.convertToEntity(userDTO));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
    }

}
