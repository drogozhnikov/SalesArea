package com.sales.service.converter;

import com.sales.dto.PositionDTO;
import com.sales.entity.PositionEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PositionConverter {

    private ModelMapper modelMapper;

    public PositionConverter(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public List<PositionDTO> convertListToDto(List<PositionEntity> entitiesList) {
        return entitiesList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public PositionDTO convertToDto(PositionEntity inputEntity) {
        return modelMapper.map(inputEntity, PositionDTO.class);
    }

    public PositionEntity convertToEntity(PositionDTO inputDTO) {
        return modelMapper.map(inputDTO, PositionEntity.class);
    }
}
