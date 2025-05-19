package com.example.blog_01.service.impl;

import com.example.blog_01.entity.Article;
import com.example.blog_01.mapper.ArticleMapper;
import com.example.blog_01.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    public Article getArticleById(Long id) {
        return articleMapper.getArticleById(id);
    }

    public int createArticle(Article article) {
        return articleMapper.insertArticle(article);
    }

    @Override
    public List<Article> getAllArticles() {
        return articleMapper.getAllArticles();
    }

    @Override
    // 获取某一分类下的文章
    public List<Article> getArticlesByCategory(Long categoryId) {
        return articleMapper.getArticlesByCategory(categoryId);
    }

}
