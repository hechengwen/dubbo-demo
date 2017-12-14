package com.hcw.dubbo.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C), 2017，jumore Tec.
 * Author: hechengwen
 * Version:
 * Date: 2017/12/14 13:37
 * Description:
 * Others:
 */
@Component
public class RemoteService implements InitializingBean{

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private static Map<String, ClassPathXmlApplicationContext> initMap = null;

    public static <T> T getRemoteService(Class<T> cls){
        ClassPathXmlApplicationContext context = initMap.get("context");
        return context.getBean(cls);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:consumer.xml");
        logger.info("消费dubbo服务start.....\n,context=[{}]",context.getBeanFactory());
        if (initMap == null) {
            initMap = Collections.synchronizedMap(new HashMap<String, ClassPathXmlApplicationContext>());
            initMap.put("context",context);
        }
    }
}
