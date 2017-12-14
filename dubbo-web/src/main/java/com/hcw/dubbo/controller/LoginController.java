package com.hcw.dubbo.controller;

import com.hcw.dubbo.entity.User;
import com.hcw.dubbo.service.UserService;
import com.hcw.dubbo.utils.MD5Util;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Copyright (C), 2017，jumore Tec.
 * Author: hechengwen
 * Version:
 * Date: 2017/11/29 13:16
 * Description:
 * Others:
 */
@Controller
public class LoginController {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    UserService userService;

    /**
     * 登陆页
     *
     * @param request
     * @return
     * @history
     */
    @RequestMapping(value = "/login")
    @ResponseBody
    public String login(HttpServletRequest request) throws Exception {

        User user = new User();
        for (int i = 0; i < 100; i++) {
            user.setCreateTime(new Date());
            user.setUserName("dubbo" + i);
            user.setPassword(MD5Util.getMD5("dubbo"+i));
            user.setMobile("177103638"+i);
            user.setRealName("dubbo"+i);
            userService.insert(user);
        }

            String s = userService.dubboTest();

        logger.info("Dubbo服务调用结果：-------" + s);
        return "Dubbo服务调用结果：-------" + s;
    }

}
