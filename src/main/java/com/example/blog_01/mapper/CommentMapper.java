package com.example.blog_01.mapper;

import com.example.blog_01.entity.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentMapper {
    @Select("SELECT * FROM comment WHERE article_id = #{articleId}")
    List<Comment> getCommentsByArticleId(Long articleId);

@Insert("INSERT INTO comment (article_id, user_id, content, create_time) VALUES (#{articleId}, #{userId}, #{content}, #{createTime})")
    int addComment(Comment comment);
}

