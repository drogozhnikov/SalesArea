package com.sales.service;

import com.sales.entity.CategoryEntity;
import com.sales.repository.CategoryDao;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class CategoryService {

    private CategoryDao categoryDao;
    private MessageService messageService;

    public CategoryService(CategoryDao categoryDao, MessageService messageService) {
        this.categoryDao = categoryDao;
        this.messageService = messageService;
    }

    @Transactional
    public List<CategoryEntity> getAllCategory() {
        return categoryDao.getAllCategory();
    }

    @Transactional
    public CategoryEntity getCategory(int id) {
        return categoryDao.getCategory(id);
    }

    @Transactional
    public void addCategory(CategoryEntity categoryEntity) {
        categoryDao.addCategory(categoryEntity);
    }

    @Transactional
    public void updateCategory(CategoryEntity categoryEntity) {
        categoryDao.updateCategory(categoryEntity);
    }

    @Transactional
    public void deleteCategory(int id) {
        categoryDao.deleteCategory(id);
    }


}
