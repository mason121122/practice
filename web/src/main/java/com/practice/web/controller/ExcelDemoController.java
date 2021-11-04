package com.practice.web.controller;

import com.practice.domain.excel.easyExcel.ExcelEasyExcelUtil;
import com.practice.domain.excel.poi.ExcelPoiUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Mark Wang
 * @date 2021/11/4
 */
@Slf4j
@RestController
@Api(tags = {"ExcelDemoController"}, description = "Excel测试")
@RequestMapping(value = "/ExcelTest")
public class ExcelDemoController {

    /**
     * 测试
     *
     * @return
     */
    @ApiOperation(value = "EasyExcel测试接口", notes = "EasyExcel测试接口")
    @GetMapping(value = "/EasyExcelTest", produces = MediaType.APPLICATION_JSON_VALUE)
    public void tests(HttpServletResponse response,HttpServletRequest request) throws IOException {
        ExcelEasyExcelUtil.exportExcelByEasyExcel(request, response, 1000000);
    }

    /**
     * 测试
     *
     * @return
     */
    @ApiOperation(value = "poi测试接口", notes = "poi测试接口")
    @GetMapping(value = "/poiTest", produces = MediaType.APPLICATION_JSON_VALUE)
    public void poiTests(HttpServletResponse response,HttpServletRequest request) throws IOException {
        ExcelPoiUtil.exportExcelBySXSSFWorkbook(request, response, 1000000);
    }
}
