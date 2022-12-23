package com.sales.controller;

import com.sales.dto.CategoryDTO;
import com.sales.service.CategoryService;
import com.sales.service.converter.CategoryConverter;
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
@RequestMapping("/api/categories")
public class CategoryController {

    private CategoryService categoryService;
    private CategoryConverter converter;

    public CategoryController(CategoryService categoryService, CategoryConverter converter) {
        this.categoryService = categoryService;
        this.converter = converter;
    }

    @GetMapping("/all")
    public List<CategoryDTO> getAllCategories() {
        return converter.convertListToDto(categoryService.getAllCategory());
    }

    @GetMapping("/{id}")
    public CategoryDTO getCategoryById(@PathVariable("id") int id) {
        return converter.convertToDto(categoryService.getCategory(id));
    }

    @PostMapping("/")
    public void createCategory(@RequestBody CategoryDTO categoryDTO) {
        categoryService.addCategory(converter.convertToEntity(categoryDTO));
    }

    @PutMapping("/")
    public void updateCategory(@RequestBody CategoryDTO categoryDTO) {
        categoryService.updateCategory(converter.convertToEntity(categoryDTO));
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable("id") int id) {
        categoryService.deleteCategory(id);
    }

}
