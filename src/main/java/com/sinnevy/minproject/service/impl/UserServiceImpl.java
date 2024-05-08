package com.sinnevy.minproject.service.impl;

import com.alibaba.fastjson.JSON;
import com.sinnevy.minproject.constant.Permission;
import com.sinnevy.minproject.dao.UserDao;
import com.sinnevy.minproject.dto.UserDto;
import com.sinnevy.minproject.dto.UserRoleDto;
import com.sinnevy.minproject.service.UserService;
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

    public boolean hasSuchRole(Permission[] permissions) {
//        Integer userId = session.getUserDto().getId();
//        return hasSuchRole(permissions, userId);
        return false;
    }

    public boolean hasSuchRole(Permission[] permissions, Integer userId) {
        List<UserRoleDto> list = userDao.getRoles(userId);
        for (UserRoleDto dto : list) {
            for (Permission permission : permissions) {
                if (dto.getRoleId().equals(permission.getKey())) {
                    log.info("当前用户:{} 有权限:{}", userId, JSON.toJSONString(permission));
                    return true;
                }
            }
        }
        log.info("当前用户:{} 没有权限 in {}", userId, JSON.toJSONString(permissions));
        return false;
    }

    @Override
    public void allocateRole(Integer userId, Integer roleId) {
        if (hasSuchRole(new Permission[]{ Permission.ADMIN })) {
            userDao.addUserRole(userId, roleId);
        }
    }

    @Override
    public List<UserDto> list() {
        return userDao.all();
    }
}
