package com.sinnevy.minproject.dao;


import com.sinnevy.minproject.dto.UserDto;
import com.sinnevy.minproject.dto.UserRoleDto;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDao {

    @Select("select * from user")
    List<UserDto> all();

    @Insert("insert into user (name, account, password, tel_number) values (#{name}, #{account}, #{password}, #{telNumber}) ")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    void addUser(UserDto userDto);

    @Select("SELECT * FROM user_role WHERE user_id=#{id}")
    List<UserRoleDto> getRoles(@Param("id") Integer id);
}
