package com.sales.controller;

import com.sales.dto.CategoryDTO;
import com.sales.entity.CategoryEntity;
import com.sales.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private CategoryService categoryService;
    private ModelMapper modelMapper;

    public CategoryController(CategoryService categoryService, ModelMapper modelMapper) {
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/all")
    public List<CategoryDTO> getAllCategories() {
        List<CategoryEntity> entitiesList = categoryService.getAllCategory();
        return entitiesList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public CategoryDTO getCategoryById(@PathVariable("id") int id) {
        return convertToDto(categoryService.getCategory(id));
    }

    @PostMapping("/")
    public void createCategory(@RequestBody CategoryDTO categoryDTO) {
        categoryService.addCategory(convertToEntity(categoryDTO));
    }

    @PutMapping("/")
    public void updateCategory(@RequestBody CategoryDTO categoryDTO) {
        categoryService.updateCategory(convertToEntity(categoryDTO));
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable("id") int id) {
        categoryService.deleteCategory(id);
    }



    private CategoryDTO convertToDto(CategoryEntity inputEntity) {
        return modelMapper.map(inputEntity, CategoryDTO.class);
    }

    private CategoryEntity convertToEntity(CategoryDTO inputDTO) {
        return modelMapper.map(inputDTO, CategoryEntity.class);
    }
}
