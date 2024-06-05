package com.sinnevy.minproject.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sinnevy.minproject.dto.UserDto;
import com.sinnevy.minproject.vo.UserVo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDao extends BaseMapper<UserDto> {

    @Select("<script> "
            + "SELECT * FROM `user` "
            + " WHERE 1=1 "
            + "<if test='account != null and account != \"\"'> AND account like concat('%','#{account}','%') </if>"
            + "<if test='telNumber != null and telNumber != \"\"'> AND tel_number like concat('%','#{telNumber}','%') </if>"
            + " LIMIT ${(page-1)*pageSize}, ${pageSize} "
            + "</script>")
    List<UserDto> list(UserVo userVo);

    @Select("<script> "
            + "SELECT count(1) FROM `user` "
            + " WHERE 1=1 "
            + "<if test='account != null and account != \"\"'> AND account like concat('%','#{account}','%') </if>"
            + "<if test='telNumber != null and telNumber != \"\"'> AND tel_number like concat('%','#{telNumber}','%') </if>"
            + "</script>")
    Long count(UserVo userVo);

    @Insert("insert into user (name, account, tel_number) values (#{name}, #{account}, #{telNumber}) ")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    void addUser(UserDto userDto);

    @Select("SELECT * FROM user WHERE id=#{id}")
    UserDto getById(@Param("id") Long id);

    @Update("<script> "
            + "update `user` set "
            + "<if test='name != null and name!=\"\"'> name=#{name} </if>"
            + "<if test='account != null and account!=\"\"'> ,account=#{account} </if>"
            + "<if test='telNumber != null and telNumber!=\"\"'> ,tel_number=#{telNumber} </if>"
            + " WHERE id=#{id} "
            + " </script>")
    void updateUser(UserDto dto);

    @Delete("DELETE FROM `user` WHERE id=#{id} ")
    void deleteUser(@Param("id") Long id);


}
