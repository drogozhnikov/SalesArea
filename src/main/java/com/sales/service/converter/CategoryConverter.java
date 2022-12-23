package com.sales.service.converter;

import com.sales.dto.CategoryDTO;
import com.sales.entity.CategoryEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryConverter {

    private ModelMapper modelMapper;

    public CategoryConverter(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public List<CategoryDTO> convertListToDto(List<CategoryEntity> entitiesList){
        return entitiesList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public CategoryDTO convertToDto(CategoryEntity inputEntity) {
        return modelMapper.map(inputEntity, CategoryDTO.class);
    }

    public CategoryEntity convertToEntity(CategoryDTO inputDTO) {
        return modelMapper.map(inputDTO, CategoryEntity.class);
    }
}
