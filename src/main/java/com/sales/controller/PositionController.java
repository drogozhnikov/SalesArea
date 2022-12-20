package com.sales.controller;

import com.sales.dto.PositionDTO;
import com.sales.entity.PositionEntity;
import com.sales.service.PositionService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/positions")
public class PositionController {

    private PositionService positionService;
    private ModelMapper modelMapper;

    public PositionController(PositionService positionService, ModelMapper modelMapper) {
        this.positionService = positionService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/all")
    public List<PositionDTO> getAllPositions() {
        List<PositionEntity> entitiesList = positionService.getAllPosition();
        return entitiesList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PositionDTO getPositionById(@PathVariable("id") int id) {
        return convertToDto(positionService.getPosition(id));
    }

    @PostMapping("/")
    public void createPosition(@RequestBody PositionDTO positionDTO) {
        positionService.addPosition(convertToEntity(positionDTO));
    }

    @PutMapping("/")
    public void updatePosition(@RequestBody PositionDTO positionDTO) {
        positionService.updatePosition(convertToEntity(positionDTO));
    }

    @DeleteMapping("/{id}")
    public void deletePosition(@PathVariable("id") int id) {
        positionService.deletePosition(id);
    }


    private PositionDTO convertToDto(PositionEntity inputEntity) {
        return modelMapper.map(inputEntity, PositionDTO.class);
    }

    private PositionEntity convertToEntity(PositionDTO inputDTO) {
        return modelMapper.map(inputDTO, PositionEntity.class);
    }
}
