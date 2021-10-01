package com.practice.web.controller;

import com.practice.model.enums.ResultEnum;
import com.practice.model.resp.UserVo;
import com.practice.model.result.ReturnResult;
import com.practice.service.UserService;
import com.practice.web.support.ResultBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Autowired
    private UserService userService;


    /**
     * 测试
     *
     * @return
     */
    @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer tests() {
        return ResultEnum.SUCCESS.getCode();
    }


    @GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ReturnResult<UserVo> findUser() {
        return ResultBuilder.success(userService.findAllUser());
    }
}
