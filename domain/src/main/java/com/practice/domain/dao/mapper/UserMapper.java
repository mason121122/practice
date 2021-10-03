package com.practice.domain.dao.mapper;

import com.practice.domain.dao.po.master.UserPo;
import org.springframework.stereotype.Repository;

/**
 * @author Mark Wang
 * @date 2021/10/1
 */

@Repository
public interface UserMapper {

    UserPo findAllUser();
}
