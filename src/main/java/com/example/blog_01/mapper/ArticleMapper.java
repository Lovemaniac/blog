package com.example.blog_01.mapper;

import com.example.blog_01.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

@Mapper
public interface ArticleMapper {
    @Select("SELECT * FROM article WHERE id = #{id}")
    Article getArticleById(Long id);

    @Insert("INSERT INTO article (title, content, user_id, category_id) VALUES (#{title}, #{content}, #{userId}, #{categoryId})")
    int insertArticle(Article article);
    @Select("SELECT * FROM article")
    List<Article> getAllArticles();
    @Select("SELECT * FROM article WHERE category_id = #{categoryId}")
    //This method returns a list of articles based on the category id
    List<Article> getArticlesByCategory(Long categoryId);
}
