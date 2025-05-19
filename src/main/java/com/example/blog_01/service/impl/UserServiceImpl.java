package com.example.blog_01.service.impl;

import com.example.blog_01.entity.User;
import com.example.blog_01.mapper.UserMapper;
import com.example.blog_01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User getUserById(Long id){
        return userMapper.getUserById(id);
    }

    @Override
    public boolean register(User user) {
        return userMapper.register(user)==1?true:false;
    }

    @Override

        // 用户登录
        public boolean login(String username, String password) {
            // 根据用户名查找用户
            User user = userMapper.getUserByUsername(username);

            if (user == null) {
                return false;  // 用户名不存在
            }

            // 简化版：直接对比明文密码（实际上应该使用加密后的密码对比）
            return user.getPassword().equals(password);
        }

}
