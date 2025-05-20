package com.example.blog_01.controller;

import com.example.blog_01.entity.User;
import com.example.blog_01.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // 注册用户
    @PostMapping("/register")
    public String register(@RequestBody User user) {
        boolean success = userService.register(user);
        return success ? "注册成功" : "注册失败";
    }

    // 用户登录（简化版）
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpServletResponse response) {
        boolean success = userService.login(username, password);
        if (success) {
            // 假设我们有一个方法getUserByUsername来获取用户信息
            User user = userService.getUserByUsername(username);
            // 将用户ID设置到响应头中
            response.setHeader("userId", String.valueOf(user.getId()));
        }
        return success ? "登录成功" : "登录失败";
    }

    // 获取用户信息
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}

