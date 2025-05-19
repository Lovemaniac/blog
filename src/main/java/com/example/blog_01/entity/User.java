package com.example.blog_01.entity;

import lombok.Data;

import java.util.Date;
@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private Date createTime;

    // Getters and Setters
}


