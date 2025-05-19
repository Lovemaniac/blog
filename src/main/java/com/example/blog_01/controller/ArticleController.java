package com.example.blog_01.controller;

import com.example.blog_01.entity.Article;
import com.example.blog_01.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    // 创建文章
    @PostMapping("/create")
    public String createArticle(@RequestBody Article article) {
        int result = articleService.createArticle(article);
        return result > 0 ? "文章创建成功" : "文章创建失败";
    }

    // 获取文章列表
    @GetMapping("/")
    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }

    // 获取文章详情
    @GetMapping("/{id}")
    public Article getArticle(@PathVariable Long id) {
        return articleService.getArticleById(id);
    }

    // 获取某一分类下的文章
    @GetMapping("/category/{categoryId}")
    public List<Article> getArticlesByCategory(@PathVariable Long categoryId) {
        return articleService.getArticlesByCategory(categoryId);
    }
}

