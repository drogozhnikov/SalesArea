package com.sales.controller;

import com.sales.entity.PositionEntity;
import com.sales.service.PositionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/positions")
public class PositionController {

    private PositionService positionService;

    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping("/all")
    public List<PositionEntity> getAllPositions() {
        return positionService.getAllPosition();
    }

    @GetMapping("/{id}")
    public PositionEntity getPositionById(@PathVariable("id") int id) {
        return positionService.getPosition(id);
    }

    @PostMapping("/")
    public void createPosition(@RequestBody PositionEntity positionEntity) {
        positionService.addPosition(positionEntity);
    }

    @PutMapping("/")
    public void updatePosition(@RequestBody PositionEntity positionEntity) {
        positionService.updatePosition(positionEntity);
    }

    @DeleteMapping("/{id}")
    public void deletePosition(@PathVariable("id") int id) {
        positionService.deletePosition(id);
    }
}
