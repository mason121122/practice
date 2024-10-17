package com.practice.web.controller;

import com.practice.model.enums.ResultEnum;
import com.practice.model.page.PageResponse;
import com.practice.model.resp.MemberVo;
import com.practice.model.result.ReturnResult;
import com.practice.service.MemberService;
import com.practice.web.support.ResultBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@Api(tags = {"MemberController"}, description = "会员接口")
@RequestMapping(value = "/memberController")
public class MemberController {
    @Autowired
    private MemberService memberService;

    /**
     *
     *  @ApiOperation(value = "api说明", notes = "接口发布说明", httpMethod = "请求方式 [ POST | GET ]")
     *
     *  @RequestMapping(value = "URL地址" , method = "传输方式 [ RequestMethod.GET | RequestMethod.POST] ")
     *
     *  @ApiParam  是注解api的参数 ，也就是用于swagger提供开发者文档 ，文档中生成的注释内容,接受 POST 或者 GET 参数
     *      @ApiParam ( name = "参数名称" , value = "api描述" , required = 是否必传[ true(必传) 接收的值 | false(非传) 默认等于 null ] ) 类型 参数绑定
     *
     *  @PathVariable 表示参数跟在url后面，例：/memberListPagingQuery/张三/101,22/0/张三丰
     *      参数：value、参数名，required、参数种是否必须提供此参数，true为必须提供，defaultValue、默认值，如果defaultValue和required同时存在required失效
     *
     *  @RequestParam,是获取前端传递给后端的参数，可以是get方式，也可以是post方式。其中如果前端传递的参数和后端你接受的参数起的名字字段是一致的可以省略不写，
     *      也可以直接写@RequestParam String title,如果不一致一定要完整写
     *       @RequestParam(name = "参数名称",required = "是否必传[ true(必传) | false(非传) ] 默认 true", defaultValue = "默认值") 类型 参数绑定
     */
    @ApiOperation(value = "会员分页查询接口", notes = "会员分页查询接口")
    @GetMapping(value = "/memberListPagingQuery/{name}/{integrals}/{gender}/{memberName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ReturnResult<PageResponse<MemberVo>> memberListPagingQuery(@ApiParam(value = "姓名", required = true) @PathVariable(value = "name", required = true)String name,
                                                               @ApiParam(value = "积分", required = true) @PathVariable(value = "integrals", required = true)int[] integrals,
                                                               @ApiParam(value = "性别", required = true) @PathVariable(value = "gender", required = true)Integer gender,
                                                               @ApiParam(value = "会员名", required = true) @PathVariable(value = "memberName", required = true)String memberName,
                                                               @ApiParam(value = "页码", required = true) @RequestParam(value = "pageIndex", required = true)Integer pageIndex,
                                                               @ApiParam(value = "显示条数", required = true) @RequestParam(value = "pageSize", required = true)Integer pageSize) {
        return ResultBuilder.success(memberService.memberListPagingQuery(name,integrals,gender,memberName,pageIndex,pageSize));
    }

    @ApiOperation(value = "新增会员", notes = "新增会员")
    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ReturnResult<?> create(
            @ApiParam(value = "操作人id", required = true) @RequestHeader(value = "userid", required = true) String userId,
            @ApiParam(value = "操作人name", required = true) @RequestHeader(value = "username", required = true) String userName,
            @RequestBody MemberVo memberVo) {
        Integer i = memberService.addMember(memberVo);
        if(null == i || i == 0){
            return ResultBuilder.buildResult(ResultEnum.ERROR);
        }
        return ResultBuilder.success();
    }

    @ApiOperation(value = "删除会员", notes = "删除会员")
    @DeleteMapping(value = "/{id:\\d+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ReturnResult<?> removeMember(
            @ApiParam(value = "操作人id", required = true) @RequestHeader(value = "userid", required = true) String userId,
            @ApiParam(value = "操作人name", required = true) @RequestHeader(value = "username", required = true) String userName,
            @ApiParam(value = "id", required = true) @PathVariable(value = "id", required = true) Long id) {
        Integer i = memberService.removeMember(id);
        if(null == i || i == 0){
            return ResultBuilder.buildResult(ResultEnum.ERROR);
        }
        return ResultBuilder.success();
    }

    @ApiOperation(value = "会员修改接口", notes = "会员修改接口")
    @PutMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ReturnResult<?> edit(
            @ApiParam(value = "操作人id", required = true) @RequestHeader(value = "userid", required = true) String userId,
            @ApiParam(value = "操作人name", required = true) @RequestHeader(value = "username", required = true) String userName,
            @RequestBody @Valid MemberVo memberVo) {
        Integer i = memberService.updateMember(memberVo);
        if(null == i || i == 0){
            return ResultBuilder.buildResult(ResultEnum.ERROR);
        }
        return ResultBuilder.success();
    }

}
