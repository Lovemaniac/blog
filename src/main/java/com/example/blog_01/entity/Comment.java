package com.example.blog_01.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Comment {
    // 评论的ID
    private Long id;
    // 文章的ID
    private Long articleId;
    // 用户名
    private String username;
    // 评论内容
    private String content;
    // 评论时间
    private Date createTime;

    // Getters and Setters
}
