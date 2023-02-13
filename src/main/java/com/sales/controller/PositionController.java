package com.sales.controller;

import com.sales.dto.PositionDTO;
import com.sales.service.PositionService;
import com.sales.service.converter.PositionConverter;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping("/api/positions")
public class PositionController {

    private PositionService positionService;
    private PositionConverter converter;

    public PositionController(PositionService positionService, PositionConverter converter) {
        this.positionService = positionService;
        this.converter = converter;
    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('developers:read')")
    public List<PositionDTO> getAllPositions() {
        return converter.convertListToDto(positionService.getAllPosition());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('developers:read')")
    public PositionDTO getPositionById(@PathVariable("id") int id) {
        return converter.convertToDto(positionService.getPosition(id));
    }

    @PostMapping("/")
    @PreAuthorize("hasAuthority('developers:write')")
    public void createPosition(@RequestBody PositionDTO positionDTO) {
        positionService.addPosition(converter.convertToEntity(positionDTO));
    }

    @PutMapping("/")
    @PreAuthorize("hasAuthority('developers:write')")
    public void updatePosition(@RequestBody PositionDTO positionDTO) {
        positionService.updatePosition(converter.convertToEntity(positionDTO));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('developers:write')")
    public void deletePosition(@PathVariable("id") int id) {
        positionService.deletePosition(id);
    }

}
