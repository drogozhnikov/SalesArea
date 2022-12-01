package com.sales.controller;

import com.sales.entity.CategoryEntity;
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
    public List<CategoryEntity> getAllCategories() {
        return categoryService.getAllCategory();
    }

    @GetMapping("/{id}")
    public CategoryEntity getCategoryById(@PathVariable("id") int id) {
        return categoryService.getCategory(id);
    }

    @PostMapping("/")
    public void createCategory(@RequestBody CategoryEntity categoryEntity) {
        categoryService.addCategory(categoryEntity);
    }

    @PutMapping("/")
    public void updateCategory(@RequestBody CategoryEntity categoryEntity) {
        categoryService.updateCategory(categoryEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable("id") int id) {
        categoryService.deleteCategory(id);
    }
}
