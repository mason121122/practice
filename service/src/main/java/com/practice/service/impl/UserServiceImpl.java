package com.practice.service.impl;

import com.practice.common.constants.DataSourceConstants;
import com.practice.common.utils.ClazzConverter;
import com.practice.domain.annotation.DS;
import com.practice.domain.dao.mapper.UserMapper;
import com.practice.domain.dao.po.UserPo;
import com.practice.model.resp.UserVo;
import com.practice.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public List<UserVo> findAllUser() {
        List<UserVo> userVo = new ArrayList<>();
        List<UserPo> userPo = userMapper.findAllUser();
        if(null != userPo){
            userVo = ClazzConverter.converterClass(userPo,UserVo.class);
        }
        return userVo;
    }

    @DS(DataSourceConstants.SLAVE_DATA_SOURCE)
    @Override
    public List<UserVo> findAllUser2() {
        List<UserVo> userVo = new ArrayList<>();
        List<UserPo> userPo = userMapper.findAllUser();
        if(null != userPo){
            userVo = ClazzConverter.converterClass(userPo,UserVo.class);
        }
        return userVo;
    }

    @Override
    public UserVo findUserByUserName(String userName) {
        UserVo userVo = new UserVo();
        UserPo userPo = userMapper.findUserByUserName(userName);
        BeanUtils.copyProperties(userPo,userVo);
        return userVo;
    }
}
