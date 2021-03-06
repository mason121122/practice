package com.practice.service.impl;

import com.practice.common.constants.DataSourceConstants;
import com.practice.domain.annotation.DS;
import com.practice.domain.dao.mapper.UserMapper;
import com.practice.domain.dao.po.UserPo;
import com.practice.model.resp.UserVo;
import com.practice.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Mark Wang
 * @date 2021/10/1
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @DS(DataSourceConstants.MASTER_DATA_SOURCE)
    @Override
    public UserVo findAllUser() {
        UserVo userVo = new UserVo();
        UserPo userPo = userMapper.findAllUser();
        if(null != userPo){
            BeanUtils.copyProperties(userMapper.findAllUser(), userVo);
        }
        return userVo;
    }

    @DS(DataSourceConstants.SLAVE_DATA_SOURCE)
    @Override
    public UserVo findAllUser2() {
        UserVo userVo = new UserVo();
        UserPo userPo = userMapper.findAllUser();
        if(null != userPo){
            BeanUtils.copyProperties(userMapper.findAllUser(), userVo);
        }
        return userVo;
    }
}
