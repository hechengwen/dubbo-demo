package com.hcw.dubbo.service.impl;

import com.dubbo.hcw.service.TestService;
import com.hcw.dubbo.dao.UserMapper;
import com.hcw.dubbo.entity.User;
import com.hcw.dubbo.service.UserService;
import com.hcw.dubbo.utils.RemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Copyright (C), 2017，jumore Tec.
 * Author: hechengwen
 * Version:
 * Date: 2017/11/29 13:39
 * Description:
 * Others:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public User login(String username, String password) {
        return userMapper.login(username,password);
    }

    @Override
    public String dubboTest() {
        TestService testService = RemoteService.getRemoteService(TestService.class);

        String s = testService.test("我是一个小dubbo");
        return s;
    }
}
