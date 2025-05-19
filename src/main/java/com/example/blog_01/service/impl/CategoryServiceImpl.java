package com.example.blog_01.service.impl;

import com.example.blog_01.entity.Category;
import com.example.blog_01.mapper.ArticleMapper;
import com.example.blog_01.mapper.CategoryMapper;
import com.example.blog_01.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    // 获取所有分类
    public List<Category> getAllCategories() {
        return categoryMapper.getAllCategories();
    }

    // 创建新分类
    public boolean createCategory(Category category) {
        int result = categoryMapper.insertCategory(category);
        return result > 0;  // 如果插入成功，返回 true
    }
    public Category getCategoryById(Long id){
        return categoryMapper.getCategoryById(id);
    }
}
