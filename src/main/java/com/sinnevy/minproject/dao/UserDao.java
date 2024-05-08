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

    @Select("insert into user_role (user_id, role_id) values (#{userId}, #{roleId}) ")
    Integer addUserRole(@Param("userId") Integer userId, @Param("roleId") Integer roleId);

    @Select("SELECT * FROM user_role WHERE user_id=#{id}")
    List<UserRoleDto> getRoles(@Param("id") Integer id);
}
