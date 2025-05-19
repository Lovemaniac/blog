package com.example.blog_01.service;

import com.example.blog_01.entity.Article;

import java.util.List;

public interface ArticleService {
    public Article getArticleById(Long id);

    public int createArticle(Article article);


    List<Article> getAllArticles();

    List<Article> getArticlesByCategory(Long categoryId);
}
