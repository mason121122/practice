package com.practice.web.controller;

import com.practice.domain.annotation.jwt.util.JwtUtil;
import com.practice.model.enums.ResultEnum;
import com.practice.model.resp.JwtUserVo;
import com.practice.model.resp.UserVo;
import com.practice.model.result.ReturnResult;
import com.practice.service.UserService;
import com.practice.web.support.ResultBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Mark Wang
 * @date 2021/10/17
 */
@Slf4j
@RestController
@Api(tags = {"JwtDemoController"}, description = "demo接口")
@RequestMapping(value = "/JwtDemo")
public class JwtDemoController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil tokenUtils;

    @ApiOperation(value = "jwtDemo", notes = "jwtDemo")
    @PostMapping("/login")
    public ReturnResult<JwtUserVo> login(@RequestParam(value = "userName", required = true) String userName,
                                         @RequestParam(value = "password", required = true) String password) {
        JwtUserVo jwtUserVo = new JwtUserVo();
        UserVo user = userService.findUserByUserName(userName);
        BeanUtils.copyProperties(user, jwtUserVo);
        if (user == null) {
            return ResultBuilder.buildResult(ResultEnum.LOGIN_ERR);
        } else {
            if (!user.getPassword().equals(password)) {
                return ResultBuilder.buildResult(ResultEnum.LOGIN_ERR);
            } else {
                jwtUserVo.setToken(JwtUtil.createToken(user));
                return ResultBuilder.success(jwtUserVo);
            }
        }
    }

}
