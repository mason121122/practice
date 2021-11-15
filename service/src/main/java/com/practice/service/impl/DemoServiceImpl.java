package com.practice.service.impl;

import com.practice.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * @author Mark Wang
 * @date 2021/9/30
 */
@Slf4j
@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private WebApplicationContext wac;
    @Override
    public void test(){
        try {
            Class<?> cls = Class.forName("com.practice.service.UserService");
            // 获取spring中的bean对象
            Object bean = applicationContext.getBean(cls);
            // 获取mybatis方法.形参是待执行方法名
            Method method = cls.getMethod("findAllUser");
            // 执行方法
            Object object =  method.invoke(bean);
        } catch (ClassNotFoundException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
