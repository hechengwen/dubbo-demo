package com.dubbo.hcw.service.impl;

import com.dubbo.hcw.service.DemoService;

/**
 * Copyright (C), 2017，jumore Tec.
 * Author: hechengwen
 * Version:
 * Date: 2017/12/12 14:39
 * Description:
 * Others:
 */
public class DemoServiceImpl implements DemoService{
    @Override
    public String getPermissions(String s) {
        System.out.println(s+":00000000");
        return s + ":000000000";
    }
}
