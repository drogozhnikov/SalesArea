package com.sales.repository;

import com.sales.entity.Category;

import java.util.List;

public interface CategoryDao {

    public List<Category> getAllCategory();

    public Category getCategory(int id);

    public Category addCategory(Category category);

    public void updateCategory(Category category);

    public void deleteCategory(int id);
}
