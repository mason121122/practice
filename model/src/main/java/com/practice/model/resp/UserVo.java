package com.practice.model.resp;

import lombok.Data;

import java.util.Date;

/**
 * @author Mark Wang
 * @date 2021/10/1
 */
@Data
public class UserVo {
    /**
     * id
     */
    private Integer id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     */
    private String sex;
    /**
     * 生日
     */
    private Date birthday;
}
