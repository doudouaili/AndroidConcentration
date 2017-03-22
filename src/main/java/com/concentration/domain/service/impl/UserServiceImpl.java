package com.concentration.domain.service.impl;

import com.concentration.domain.service.IUserService;
import com.concentration.domain.jpa.User;

import javax.annotation.Resource;

import com.concentration.domain.dao.UserMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Created by ali on 2017/3/21.
 */
@Repository
public class UserServiceImpl implements IUserService {

    @Resource
    UserMapper userMapper;

    public int insertUser(User user) {
        int i = userMapper.insertUser(user);
        return i;
    }
}
