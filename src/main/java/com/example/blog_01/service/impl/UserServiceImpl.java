package com.example.blog_01.service.impl;

import com.example.blog_01.entity.User;
import com.example.blog_01.mapper.UserMapper;
import com.example.blog_01.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Slf4j
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
        // 参数校验，避免传入空对象
        if (user == null) {
            log.warn("注册用户失败：用户对象为空");
            return false;
        }

        try {
            // 执行数据库插入操作
            int rows = userMapper.register(user);
            boolean success = rows == 1;

            // 记录操作结果
            if (success) {
                log.info("用户注册成功：userId={}", user.getId());
            } else {
                log.warn("用户注册失败：影响行数={}", rows);
            }

            return success;
        } catch (Exception e) {
            // 异常处理，记录详细错误信息
            log.error("用户注册异常：username={}", user.getUsername(), e);
            return false;
        }
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

    @Override
    public User getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }

}
