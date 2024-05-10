package com.sinnevy.minproject.service;


import com.sinnevy.minproject.dto.UserDto;
import com.sinnevy.minproject.vo.PageVo;
import com.sinnevy.minproject.vo.UserVo;

import java.util.List;

public interface UserService {

    void add(UserDto user);

    void update(UserDto user);

    void delete(Integer id);

    PageVo<UserDto> list(UserVo userVo);

}
