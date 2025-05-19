package com.example.blog_01.service;

import com.example.blog_01.entity.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> getAllCategories();

    public boolean createCategory(Category category);
    public Category getCategoryById(Long id);
}
