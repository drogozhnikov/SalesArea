package com.sales.controller;

import com.sales.entity.Category;
import com.sales.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/all")
    public List<Category> getAllUsers() {
        return categoryService.getAllCategory();
    }

    @GetMapping("/{id}")
    public Category getUserById(@PathVariable("id") int id) {
        return categoryService.getCategory(id);
    }

    @PostMapping("/")
    public void createUser(@RequestBody Category category) {
        categoryService.addCategory(category);
    }

    @PutMapping("/")
    public void updateUser(@RequestBody Category category) {
        categoryService.updateCategory(category);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        categoryService.deleteCategory(id);
    }
}
