package com.practice.web.controller;

import com.practice.model.enums.ResultEnum;
import com.practice.model.resp.UserVo;
import com.practice.model.result.ReturnResult;
import com.practice.service.UserService;
import com.practice.web.support.ResultBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Mark Wang
 * @date 2021/9/30
 */
@Slf4j
@RestController
@Api(tags = {"DemoController"}, description = "demo接口")
@RequestMapping(value = "/demo")
public class DemoController {

    @Autowired
    private UserService userService;


    /**
     * 测试
     *
     * @return
     */
    @ApiOperation(value = "测试接口", notes = "测试接口")
    @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer tests() {
        return ResultEnum.SUCCESS.getCode();
    }


    /**
     * 查询主库
     * @return
     */
    @ApiOperation(value = "多数据源master测试接口", notes = "多数据源master测试接口")
    @GetMapping(value = "/master", produces = MediaType.APPLICATION_JSON_VALUE)
    public ReturnResult<List<UserVo>> masterFindUser() {
        return ResultBuilder.success(userService.findAllUser());
    }

    /**
     * 查询主库
     * @return
     */
    @ApiOperation(value = "多数据源slave测试接口", notes = "多数据源slave测试接口")
    @GetMapping(value = "/slave", produces = MediaType.APPLICATION_JSON_VALUE)
    public ReturnResult<List<UserVo>> slaveFindUser() {
        return ResultBuilder.success(userService.findAllUser2());
    }
}
