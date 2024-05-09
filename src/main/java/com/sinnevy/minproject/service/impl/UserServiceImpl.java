package com.sinnevy.minproject.service.impl;

import com.alibaba.fastjson.JSON;
import com.sinnevy.minproject.constant.Permission;
import com.sinnevy.minproject.dao.UserDao;
import com.sinnevy.minproject.dto.UserDto;
import com.sinnevy.minproject.dto.UserRoleDto;
import com.sinnevy.minproject.service.UserService;
import com.sinnevy.minproject.vo.PageVo;
import com.sinnevy.minproject.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

//    @Autowired
//    private Session session;
    @Autowired
    private UserDao userDao;

    @Override
    public void add(UserDto user) {
        log.info("写入user：{}", JSON.toJSONString(user));
        userDao.addUser(user);
        log.info("写入后,返回user：{}", JSON.toJSONString(user));
    }

    @Override
    public PageVo<UserDto> list(UserVo userVo) {
        Long count = 1l;
        PageVo<UserDto> pageVo = new PageVo<UserDto>().init(userVo.getPage(), userVo.getPageSize(), count);

        List<UserDto> list = userDao.all();
        pageVo.setList(list);

        return pageVo;
    }
}
