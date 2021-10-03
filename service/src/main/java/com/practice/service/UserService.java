package com.practice.service;

import com.practice.model.resp.UserVo;

/**
 * @author Mark Wang
 * @date 2021/10/1
 */
public interface UserService {

    /**
     * 主库查询
     * @return
     */
    UserVo findAllUser();

    /**
     * 从库查询
     * @return
     */
    UserVo findAllUser2();
}
