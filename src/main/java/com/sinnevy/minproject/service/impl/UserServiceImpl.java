package com.sinnevy.minproject.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sinnevy.minproject.dao.UserDao;
import com.sinnevy.minproject.dto.UserDto;
import com.sinnevy.minproject.service.UserService;
import com.sinnevy.minproject.vo.PageVo;
import com.sinnevy.minproject.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserDao, UserDto> implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void add(UserDto user) {
        log.info("写入user：{}", JSON.toJSONString(user));
        userDao.insert(user);
        log.info("写入后,返回user：{}", JSON.toJSONString(user));
    }

    @Override
    public void update(UserDto user) {
        log.info("更新user：{}", JSON.toJSONString(user));
        userDao.updateById(user);
        log.info("更新后user：{}", userDao.selectById(user.getId()));
    }

    @Override
    public void delete(Long id) {
        log.info("删除user：{}", id);
        userDao.deleteUser(id);
    }

    @Override
    public PageVo<UserDto> list(UserVo userVo) {
        // 如果不传入name 执行eq(UserDto::getName, userVo.getName())查询后返回为空
        int count = this.count(new LambdaQueryWrapper<UserDto>()
//                .eq(UserDto::getName, userVo.getName())
                .eq(UserDto::getAccount, userVo.getAccount()));
        PageVo<UserDto> pageVo = new PageVo<UserDto>().init(userVo.getPage(), userVo.getPageSize(), (long) count);
        List<UserDto> list = userDao.selectList(new LambdaQueryWrapper<UserDto>()
//                .eq(UserDto::getName, userVo.getName())
                .eq(UserDto::getAccount, userVo.getAccount()));
        pageVo.setList(list);
        return pageVo;
    }
}
