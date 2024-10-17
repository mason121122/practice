package com.practice.model.resp;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 会员表
 */
@Data
public class MemberVo {
    /**
     * @ApiModelProperty()用于方法，字段； 表示对model属性的说明或者数据操作更改
     * value–字段说明
     * name–重写属性名字 ，
     * dataType–重写属性类型
     * required–是否必填
     * example–举例说明
     * hidden–隐藏
     *
     */

    private Long id;
    @ApiModelProperty(value = "姓名", dataType = "String")
    private String name;
    @ApiModelProperty(value = "性别", dataType = "Integer")
    private Integer gender;
    @ApiModelProperty(value = "会员名", dataType = "String")
    private String memberName;
    @ApiModelProperty(value = "会员id", dataType = "String")
    private String memberId;
    @ApiModelProperty(value = "积分", dataType = "Integer")
    private Integer integral;
    @ApiModelProperty(value = "头像", dataType = "byte[]")
    private byte[] profilePhoto;
    @ApiModelProperty(value = "版本号", dataType = "Long")
    private Long version;
}
