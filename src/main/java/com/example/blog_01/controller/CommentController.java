package com.example.blog_01.controller;

import com.example.blog_01.entity.Comment;
import com.example.blog_01.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    // 添加评论
    @PostMapping("/create")
    public String createComment(@RequestBody Comment comment) {
        int result = commentService.addComment(comment);
        return result > 0 ? "评论添加成功" : "评论添加失败";
    }

    // 获取某篇文章的评论
    @GetMapping("/article/{articleId}")
    public List<Comment> getCommentsByArticle(@PathVariable Long articleId) {
        return commentService.getCommentsByArticleId(articleId);
    }
}
