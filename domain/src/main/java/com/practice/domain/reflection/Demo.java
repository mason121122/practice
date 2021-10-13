package com.practice.domain.reflection;

import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by Mark Wang on 14:35 2021/10/13.
 */
@Component
public class Demo {
    public String find() {
        return "通过反射调用find方法";
    }

}
