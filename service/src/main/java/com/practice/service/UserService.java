package com.practice.service;

import com.practice.model.resp.UserVo;

import java.util.List;

/**
 * @author Mark Wang
 * @date 2021/10/1
 */
public interface UserService {

    /**
     * 主库查询
     * @return
     */
    List<UserVo> findAllUser();

    /**
     * 从库查询
     * @return
     */
    List<UserVo> findAllUser2();

    UserVo findUserById(Integer userId);
}
