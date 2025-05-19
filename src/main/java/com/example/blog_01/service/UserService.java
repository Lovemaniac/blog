package com.example.blog_01.service;

import com.example.blog_01.entity.User;

public interface UserService {
    public User getUserById(Long id);

    boolean register(User user);

    boolean login(String username, String password);
}
