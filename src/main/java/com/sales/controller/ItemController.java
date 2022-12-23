package com.sales.controller;

import com.sales.dto.ItemDTO;
import com.sales.service.ItemService;
import com.sales.service.converter.ItemConverter;
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
@RequestMapping("/api/items")
public class ItemController {

    private ItemService itemService;
    private ItemConverter converter;

    public ItemController(ItemService itemService, ItemConverter converter) {
        this.itemService = itemService;
        this.converter = converter;
    }

    @GetMapping("/all")
    public List<ItemDTO> getAllItems() {
        return converter.convertListToDto(itemService.getAllItem());
    }

    @GetMapping("/{id}")
    public ItemDTO getItemById(@PathVariable("id") int id) {
        return converter.convertToDto(itemService.getItem(id));
    }

    @PostMapping("/")
    public void createItem(@RequestBody ItemDTO itemDTO) {
        itemService.addItem(converter.convertToEntity(itemDTO));
    }

    @PutMapping("/")
    public void updateItem(@RequestBody ItemDTO itemDTO) {
        itemService.updateItem(converter.convertToEntity(itemDTO));
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable("id") int id) {
        itemService.deleteItem(id);
    }

}
