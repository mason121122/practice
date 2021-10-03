package com.practice.model.resp;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author Mark Wang
 * @date 2021/10/1
 */
@Data
public class UserVo {
    @ApiModelProperty(value = "主键id", dataType = "Integer")
    private Integer id;
    @ApiModelProperty(value = "姓名", dataType = "String")
    private String name;
    @ApiModelProperty(value = "性别", dataType = "String")
    private String sex;
    @ApiModelProperty(value = "生日", dataType = "Date")
    private Date birthday;
}
