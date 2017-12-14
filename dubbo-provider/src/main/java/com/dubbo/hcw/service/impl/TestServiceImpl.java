package com.dubbo.hcw.service.impl;

import com.dubbo.hcw.service.TestService;

import java.util.List;

/**
 * Copyright (C), 2017，jumore Tec.
 * Author: hechengwen
 * Version:
 * Date: 2017/12/12 16:05
 * Description:
 * Others:
 */
public class TestServiceImpl implements TestService{
    @Override
    public String test(String s) {
        System.out.println(s+":00000000");
        return s + ":000000000";
    }

    @Override
    public List<String> getString(String s) {
        return null;
    }
}
