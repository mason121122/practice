package com.practice.model.bo;

import lombok.Data;

import java.util.Date;

/**
 * @author Mark Wang
 * @date 2021/10/1
 */
@Data
public class UserBo {
    /**
     * id
     */
    private Integer id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
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
