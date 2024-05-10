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
    public void update(UserDto user) {
        log.info("更新user：{}", JSON.toJSONString(user));
        userDao.updateUser(user);
        log.info("更新后user：{}", userDao.getById(user.getId()));
    }

    @Override
    public void delete(Integer id) {
        log.info("删除user：{}", id);
        userDao.deleteUser(id);
    }

    @Override
    public PageVo<UserDto> list(UserVo userVo) {
        Long count = userDao.count(userVo);
        PageVo<UserDto> pageVo = new PageVo<UserDto>().init(userVo.getPage(), userVo.getPageSize(), count);
        List<UserDto> list = userDao.list(userVo);
        pageVo.setList(list);
        return pageVo;
    }
}
