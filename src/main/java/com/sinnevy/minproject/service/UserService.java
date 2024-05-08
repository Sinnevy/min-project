package com.sinnevy.minproject.service;


import com.sinnevy.minproject.dto.UserDto;

import java.util.List;

public interface UserService {

    /**
     * 给用户分配角色
     * @param userId 用户id
     * @param roleId 角色id
     */
    void allocateRole(Integer userId, Integer roleId);

    List<UserDto> list();

}
