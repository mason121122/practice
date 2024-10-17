package com.practice.domain.dao.po;

import lombok.Data;

import java.sql.Timestamp;

/**
 * 会员表
 */
@Data
public class MemberPo {
    private Long id;
    /**
     *  姓名
     */
    private String name;
    /**
     *  性别
     */
    private Integer gender;
    /**
     *  会员名
     */
    private String memberName;
    /**
     *  会员id
     */
    private String memberId;
    /**
     *  积分
     */
    private Integer integral;
    /**
     *  头像
     */
    private byte[] profilePhoto;
    /**
     *  版本号
     */
    private Long version;
    /**
     *  创建人
     */
    private String createUser;
    /**
     *  创建时间
     */
    private Timestamp createTime;
    /**
     *  修改人
     */
    private String updateUser;
    /**
     *  修改时间
     */
    private Timestamp updateTime;

}
