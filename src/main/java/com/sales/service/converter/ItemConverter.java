package com.sales.service.converter;

import com.sales.dto.ItemDTO;
import com.sales.entity.ItemEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ItemConverter {

    private ModelMapper modelMapper;

    public ItemConverter(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public List<ItemDTO> convertListToDto(List<ItemEntity> entitiesList) {
        return entitiesList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public ItemDTO convertToDto(ItemEntity inputEntity) {
        return modelMapper.map(inputEntity, ItemDTO.class);
    }

    public ItemEntity convertToEntity(ItemDTO inputDTO) {
        return modelMapper.map(inputDTO, ItemEntity.class);
    }
}
