package com.practice.config;

import com.practice.filter.UserInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author Mark Wang
 * @date 2021/10/17
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {
    @Autowired
    private UserInterceptor interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加拦截器，配置拦截地址
        registry.addInterceptor((HandlerInterceptor) interceptor).addPathPatterns("/secure/**");
    }
}
