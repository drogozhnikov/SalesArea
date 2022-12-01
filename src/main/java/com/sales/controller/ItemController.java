package com.sales.controller;

import com.sales.entity.Item;
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
    public List<Item> getAllUsers() {
        return itemService.getAllItem();
    }

    @GetMapping("/{id}")
    public Item getUserById(@PathVariable("id") int id) {
        return itemService.getItem(id);
    }

    @PostMapping("/")
    public void createUser(@RequestBody Item item) {
        itemService.addItem(item);
    }

    @PutMapping("/")
    public void updateUser(@RequestBody Item item) {
        itemService.updateItem(item);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        itemService.deleteItem(id);
    }
}
