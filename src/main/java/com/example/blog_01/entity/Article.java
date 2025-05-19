package com.example.blog_01.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Article {
    private Long id;
    private String title;
    private String content;
    private Date createTime;
    private Long userId;
    private Long categoryId;

    // Getters and Setters
}
