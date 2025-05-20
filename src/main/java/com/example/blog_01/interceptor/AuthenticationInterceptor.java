package com.example.blog_01.interceptor;

import com.example.blog_01.entity.User;
import com.example.blog_01.mapper.UserMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;



@Component
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 从数据库中获取用户角色
        String userId = request.getHeader("userId");
        if (userId == null) {
            response.sendRedirect("/login"); // 如果没有userId，重定向到登录页面
            return false;}
        User user = userMapper.getUserById(Long.parseLong(userId));
        String role = user.getRole();
        if ("admin".equals(role)) {
            return true; // 如果是管理员，允许访问
        } else {
            response.sendRedirect("/access-denied"); // 否则重定向到访问拒绝页面
            return false;
        }

    }

}
