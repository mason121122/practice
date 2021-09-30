package com.practice.web.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

/**
 * @author Mark Wang
 * @date 2021/10/1
 */
@SpringBootTest
class DemoApplicationTests {
    private static Environment env;

    @Autowired
    public void init(Environment env) {
        DemoApplicationTests.env = env;
    }
    @Test
    void contextLoads() {
        System.out.print(DemoApplicationTests.env.getProperty("user"));
    }

}
