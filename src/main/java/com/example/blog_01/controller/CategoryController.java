package com.example.blog_01.controller;

import com.example.blog_01.entity.Category;
import com.example.blog_01.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // 获取所有分类
    @GetMapping("/")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    // 创建新分类
    @PostMapping("/create")
    public String createCategory(@RequestBody Category category) {
        boolean success = categoryService.createCategory(category);
        return success ? "分类创建成功" : "分类创建失败";
    }
}

