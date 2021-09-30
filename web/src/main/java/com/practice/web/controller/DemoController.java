package com.practice.web.controller;

import com.practice.model.enums.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mark Wang
 * @date 2021/9/30
 */
@Slf4j
@RestController
@RequestMapping(value = "/demo")
public class DemoController {


    /**
     * 测试
     *
     * @return
     */
    @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer checkHeartbeat() {
        return ResultEnum.SUCCESS.getCode();
    }

}
