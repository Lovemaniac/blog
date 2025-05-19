package com.example.blog_01.service.impl;

import com.example.blog_01.entity.Comment;
import com.example.blog_01.mapper.CommentMapper;
import com.example.blog_01.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;


    @Override
    public List<Comment> getCommentsByArticleId(Long articleId) {
        return commentMapper.getCommentsByArticleId(articleId);
    }

    @Override
    public int addComment(Comment comment) {
        return commentMapper.addComment(comment);
    }
}
