package com.practice.model.dto;

import java.sql.Timestamp;

public class MemberDto {
    private Integer id;
    /**
     *  姓名
     */
    private String Name;
    /**
     *  性别
     */
    private Integer Gender;
    /**
     *  会员名
     */
    private String MemberName;
    /**
     *  会员id
     */
    private String MemberId;
    /**
     *  积分
     */
    private Integer integral;
    /**
     *  头像
     */
    private byte[] ProfilePhoto;
    /**
     *  版本号
     */
    private Long version;
    /**
     *  创建人
     */
    private String CreateUser;
    /**
     *  创建时间
     */
    private Timestamp CreateTime;
    /**
     *  修改人
     */
    private String UpdateUser;
    /**
     *  修改时间
     */
    private Timestamp UpdateTime;
    /**
     * 当前页数
     */
    private Integer pageIndex;
    /**
     * 一页显示条数
     */
    private Integer pageSize;
}
