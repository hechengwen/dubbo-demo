package service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C), 2017，jumore Tec.
 * Author: hechengwen
 * Version:
 * Date: 2017/12/12 16:17
 * Description:
 * Others:
 */
public class RemoteService {

    private static Map<String, ClassPathXmlApplicationContext> cacheMap = null;

    static {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("consumer.xml");
        context.start();
        cacheMap = Collections.synchronizedMap(new HashMap<String, ClassPathXmlApplicationContext>());
        cacheMap.put("context",context);
    }

   public static <T> T getRemoteService(Class<T> cls){
       ClassPathXmlApplicationContext context = cacheMap.get("context");
       return context.getBean(cls);
   }

}
