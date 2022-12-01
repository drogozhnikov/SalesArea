package com.sales.repository;

import com.sales.entity.CategoryEntity;

import java.util.List;

public interface CategoryDao {

    public List<CategoryEntity> getAllCategory();

    public CategoryEntity getCategory(int id);

    public CategoryEntity addCategory(CategoryEntity categoryEntity);

    public void updateCategory(CategoryEntity categoryEntity);

    public void deleteCategory(int id);
}
