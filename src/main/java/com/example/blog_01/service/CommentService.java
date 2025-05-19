package com.example.blog_01.service;

import com.example.blog_01.entity.Comment;

import java.util.List;

public interface CommentService {
    public List<Comment> getCommentsByArticleId(Long articleId);

    int addComment(Comment comment);
}
