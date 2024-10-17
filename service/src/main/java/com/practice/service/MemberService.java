package com.practice.service;

import com.practice.model.page.PageResponse;
import com.practice.model.resp.MemberVo;

public interface MemberService {

    /**
     * 新增会员
     * @param memberVo 会员模型
     * @return
     */
    Integer addMember(MemberVo memberVo);

    /**
     * 删除会员
     * @param id id
     * @return
     */
    Integer removeMember(Long id);

    /**
     * 修改会员
     * @param memberVo 会员模型
     * @return
     */
    Integer updateMember(MemberVo memberVo);

    /**
     * 分页查询
     * @param name  姓名
     * @param integrals 积分
     * @param gender    性别
     * @param memberName   会员名
     * @param pageIndex 当前页数
     * @param pageSize  显示条数
     * @return
     */
    PageResponse<MemberVo> memberListPagingQuery(String name, int[] integrals, Integer gender,
                                                 String memberName, Integer pageIndex,
                                                 Integer pageSize);

}
