package com.practice.domain.dao.mapper;


import com.practice.domain.dao.po.MemberPo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemberMapper {
    /**
     * 新增会员
     * @param memberPo
     * @return
     */
    Integer addMember(MemberPo memberPo);

    /**
     * 删除会员
     * @param id
     * @return
     */
    Integer removeMember(Long id);

    /**
     * 修改会员
     * @param memberPo
     * @return
     */
    Integer updateMember(MemberPo memberPo);

    /**
     * 分页查询
     * @param name
     * @param integrals
     * @param gender
     * @param memberName
     * @param pageIndex
     * @param pageSize
     * @return
     */
    List<MemberPo> MemberListPagingQuery(@Param("name") String name,@Param("integrals") int[] integrals,@Param("gender") Integer gender,
                                         @Param("memberName") String memberName,@Param("pageIndex") Integer pageIndex,
                                         @Param("pageSize") Integer pageSize);

    Integer MemberListPagingQueryCount(@Param("name") String name,@Param("integrals") int[] integrals,@Param("gender") Integer gender,
                                          @Param("memberName") String memberName);

}
