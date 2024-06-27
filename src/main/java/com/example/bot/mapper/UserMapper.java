package com.example.bot.mapper;

import com.example.bot.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from user where id = #{id}")
    public User findById(Integer id);

    @Select("select * from user where email = #{email}")
    public User findByEmail(String email);

    @Insert("insert into user(email,password,salt) values (#{email},#{password},#{salt})")
    void add(String email, String password, String salt);
}
