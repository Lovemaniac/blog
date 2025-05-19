package com.example.blog_01.mapper;

import com.example.blog_01.entity.Category;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryMapper {
    @Select("SELECT * FROM category WHERE id = #{id}")
    Category getCategoryById(Long id);
    @Select("SELECT * FROM category")
    List<Category> getAllCategories();
    @Insert("INSERT INTO category (name) VALUES (#{name})")
    int insertCategory(Category category);
}
