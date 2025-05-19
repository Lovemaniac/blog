package com.example.blog_01.mapper;

import com.example.blog_01.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user WHERE id = #{id}")
    User getUserById(Long id);


    @Insert("INSERT INTO user (username, password) VALUES (#{username}, #{password})")
    int register(User user);

   @Select("SELECT * FROM user WHERE username = #{username}")
    User getUserByUsername(String username);
}

