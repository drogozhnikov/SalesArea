package com.sales.controller;

import com.sales.dto.ItemDTO;
import com.sales.entity.ItemEntity;
import com.sales.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private ItemService itemService;
    private ModelMapper modelMapper;

    public ItemController(ItemService itemService, ModelMapper modelMapper) {
        this.itemService = itemService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/all")
    public List<ItemDTO> getAllItems() {
        List<ItemEntity> entitiesList = itemService.getAllItem();
        return entitiesList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ItemDTO getItemById(@PathVariable("id") int id) {
        return convertToDto(itemService.getItem(id));
    }

    @PostMapping("/")
    public void createItem(@RequestBody ItemDTO itemDTO) {
        itemService.addItem(convertToEntity(itemDTO));
    }

    @PutMapping("/")
    public void updateItem(@RequestBody ItemDTO itemDTO) {
        itemService.updateItem(convertToEntity(itemDTO));
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable("id") int id) {
        itemService.deleteItem(id);
    }


    private ItemDTO convertToDto(ItemEntity inputEntity) {
        return modelMapper.map(inputEntity, ItemDTO.class);
    }

    private ItemEntity convertToEntity(ItemDTO inputDTO) {
        return modelMapper.map(inputDTO, ItemEntity.class);
    }
}
