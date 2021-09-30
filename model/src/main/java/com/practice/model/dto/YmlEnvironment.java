package com.practice.model.dto;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Mark Wang
 * @date 2021/9/30
 */
//@PropertySource("classpath:application.yml")
@Data
public class YmlEnvironment {
    @Value("${test.hello}")
    public static String test;
}
