package com.example.blog_01.filter;



import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@Slf4j // 声明日志注解（仅需一次）
@Component // 声明为 Spring 组件
@WebFilter(
        filterName = "loggingFilter",
        urlPatterns = "/*"// 过滤所有请求
)
public class LoggingFilter implements Filter {

    // 初始化方法（可选）
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("LoggingFilter initialized");
    }

    // 核心过滤逻辑
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // 转换为 HttpServletRequest/Response
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // 记录请求信息
        log.info("=== Request Start ===");
        log.info("URI: {}", httpRequest.getRequestURI());
        log.info("Method: {}", httpRequest.getMethod());
        log.info("Headers: {}", httpRequest.getHeaderNames().asIterator()); // 可选：记录请求头

        // 执行后续过滤器和控制器
        long startTime = System.currentTimeMillis();
        chain.doFilter(request, response); // 关键：调用 chain.doFilter() 继续处理链
        long endTime = System.currentTimeMillis();

        // 记录响应信息（在 chain.doFilter() 之后执行）
        log.info("=== Request End ===");

        log.info("Response Status: {}", httpResponse.getStatus());
        log.info("Elapsed Time: {} ms", endTime - startTime);
    }

    // 销毁方法（可选）
    @Override
    public void destroy() {
        log.info("LoggingFilter destroyed");
    }
}
