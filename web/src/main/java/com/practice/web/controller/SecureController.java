package com.practice.web.controller;

import com.practice.model.result.ReturnResult;
import com.practice.web.support.ResultBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mark Wang
 * @date 2021/10/17
 */
@Slf4j
@RestController
@Api(tags = {"SecureController"}, description = "jwt验证接口")
@RequestMapping(value = "/secure")
public class SecureController {
    @ApiOperation(value = "jwtDemo验证", notes = "jwtDemo验证")
    @GetMapping("/getMessage")
    public ReturnResult getMessage() {
        return ResultBuilder.success();
    }
}
