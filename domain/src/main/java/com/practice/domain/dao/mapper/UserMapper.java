package com.practice.domain.dao.mapper;

import com.practice.domain.dao.po.UserPo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Mark Wang
 * @date 2021/10/1
 */

@Repository
public interface UserMapper {

    List<UserPo> findAllUser();

    UserPo findUserById(Integer userId);
}
