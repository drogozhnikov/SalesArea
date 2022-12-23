package com.sales.service.converter;

import com.sales.dto.UserDTO;
import com.sales.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserConverter {

    private ModelMapper modelMapper;

    public UserConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public List<UserDTO> convertListToDto(List<UserEntity> entitiesList) {
        return entitiesList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public UserDTO convertToDto(UserEntity inputEntity) {
        return modelMapper.map(inputEntity, UserDTO.class);
    }

    public UserEntity convertToEntity(UserDTO inputDTO) {
        return modelMapper.map(inputDTO, UserEntity.class);
    }
}
