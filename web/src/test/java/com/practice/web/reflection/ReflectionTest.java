package com.practice.web.reflection;

import com.alibaba.fastjson.JSONObject;
import com.practice.domain.reflection.Demo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Mark Wang on 14:34 2021/10/13.
 */
public class ReflectionTest {
    private static final Logger logger = LoggerFactory.getLogger(ReflectionTest.class);

    public static void main(String[] args) {
        String ClassName = "com.practice.domain.reflection.Demo";
        String function = "find";
        try {
            Class<?> c1 = Class.forName(ClassName);
            Method[] methods = c1.getDeclaredMethods();
            for(Method method : methods) {
                if(method.getName().equals(function)){
                    Method m = c1.getMethod(function);
                    Object object = c1.newInstance();
                    Object a = m.invoke(object);
                    System.out.println(JSONObject.toJSONString(a));
                }
                System.out.println(method.getName());
            }
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
            logger.error("反射异常{}", e.getMessage());
        }
    }
}
