package com.sales.controller;

import com.sales.dto.UserDTO;
import com.sales.entity.UserEntity;
import com.sales.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;
    private ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/all")
    public List<UserDTO> getAllUsers() {
        List<UserEntity> entitiesList = userService.getAllUsers();
        return entitiesList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable("id") int id) {
        return convertToDto(userService.getUser(id));
    }

    @PostMapping("/")
    public void createUser(@RequestBody UserDTO userDTO) {
        userService.addUser(convertToEntity(userDTO));
    }

    @PutMapping("/")
    public void updateUser(@RequestBody UserDTO userDTO) {
        userService.updateUser(convertToEntity(userDTO));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
    }


    private UserDTO convertToDto(UserEntity inputEntity) {
        return modelMapper.map(inputEntity, UserDTO.class);
    }

    private UserEntity convertToEntity(UserDTO inputDTO) {
        return modelMapper.map(inputDTO, UserEntity.class);
    }
}
