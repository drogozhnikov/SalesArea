package com.sales.service.converter;

import com.sales.dto.CompanyDTO;
import com.sales.entity.CompanyEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CompanyConverter {

    private ModelMapper modelMapper;

    public CompanyConverter(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public List<CompanyDTO> convertListToDto(List<CompanyEntity> entitiesList) {
        return entitiesList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public CompanyDTO convertToDto(CompanyEntity inputEntity) {
        return modelMapper.map(inputEntity, CompanyDTO.class);
    }

    public CompanyEntity convertToEntity(CompanyDTO inputDTO) {
        return modelMapper.map(inputDTO, CompanyEntity.class);
    }
}
