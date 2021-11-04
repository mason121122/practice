package com.practice.model.bo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author Mark Wang
 * @date 2021/11/4
 */
@Data
public class DownloadData {

    @ExcelProperty("姓名")
    private String name;
    @ExcelProperty("年龄")
    private Integer age;
    @ExcelProperty("成绩")
    private Double score;
    @ExcelProperty("考试日期")
    private Date testDate;
    @ExcelProperty("是否合格")
    private Boolean pass;
}
