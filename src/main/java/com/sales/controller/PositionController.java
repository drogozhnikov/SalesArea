package com.sales.controller;

import com.sales.entity.Position;
import com.sales.service.PositionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class PositionController {

    private PositionService positionService;

    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping("/all")
    public List<Position> getAllUsers() {
        return positionService.getAllPosition();
    }

    @GetMapping("/{id}")
    public Position getUserById(@PathVariable("id") int id) {
        return positionService.getPosition(id);
    }

    @PostMapping("/")
    public void createUser(@RequestBody Position position) {
        positionService.addPosition(position);
    }

    @PutMapping("/")
    public void updateUser(@RequestBody Position position) {
        positionService.updatePosition(position);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        positionService.deletePosition(id);
    }
}
