package com.sales.service;

import com.sales.entity.Category;
import com.sales.repository.CategoryDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class CategoryService {

    private CategoryDao categoryDao;
    private MessageService messageService;

    public CategoryService(CategoryDao categoryDao, MessageService messageService) {
        this.categoryDao = categoryDao;
        this.messageService = messageService;
    }

    @Transactional
    public List<Category> getAllCategory() {
        return categoryDao.getAllCategory();
    }

    @Transactional
    public Category getCategory(int id) {
        return categoryDao.getCategory(id);
    }

    @Transactional
    public void addCategory(Category category) {
        categoryDao.addCategory(category);
    }

    @Transactional
    public void updateCategory(Category category) {
        categoryDao.updateCategory(category);
    }

    @Transactional
    public void deleteCategory(int id) {
        categoryDao.deleteCategory(id);
    }
}
