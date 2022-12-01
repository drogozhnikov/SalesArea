package com.sales.controller;

import com.sales.entity.ItemEntity;
import com.sales.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/all")
    public List<ItemEntity> getAllItems() {
        return itemService.getAllItem();
    }

    @GetMapping("/{id}")
    public ItemEntity getItemById(@PathVariable("id") int id) {
        return itemService.getItem(id);
    }

    @PostMapping("/")
    public void createItem(@RequestBody ItemEntity itemEntity) {
        itemService.addItem(itemEntity);
    }

    @PutMapping("/")
    public void updateItem(@RequestBody ItemEntity itemEntity) {
        itemService.updateItem(itemEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable("id") int id) {
        itemService.deleteItem(id);
    }
}
