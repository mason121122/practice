package com.practice.service.impl;

import com.practice.common.utils.ClazzConverter;
import com.practice.domain.dao.mapper.MemberMapper;
import com.practice.domain.dao.po.MemberPo;
import com.practice.model.page.PageResponse;
import com.practice.model.resp.MemberVo;
import com.practice.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberMapper memberMapper;

    @Override
    public Integer addMember(MemberVo memberVo) {
        MemberPo memberPo = ClazzConverter.converterClass(memberVo, MemberPo.class);
        return memberMapper.addMember(memberPo);
    }

    @Override
    public Integer removeMember(Long id) {
        return memberMapper.removeMember(id);
    }

    @Override
    public Integer updateMember(MemberVo memberVo) {
        MemberPo memberPo = ClazzConverter.converterClass(memberVo, MemberPo.class);
        return memberMapper.updateMember(memberPo);
    }

    @Override
    public PageResponse<MemberVo> memberListPagingQuery(String name, int[] integrals, Integer gender, String memberName, Integer pageIndex, Integer pageSize) {
        List<MemberPo> memberPos = memberMapper.MemberListPagingQuery(name, integrals, gender, memberName, pageIndex, pageSize);
        if (ObjectUtils.isEmpty(memberPos))
            return null;

        PageResponse<MemberVo> pageResponse = new PageResponse<>();
        List<MemberVo> memberVoList = new ArrayList<>();
        memberPos.forEach(memberPo->{
            MemberVo memberVo = ClazzConverter.converterClass(memberPo, MemberVo.class);
            memberVoList.add(memberVo);
        });
        pageResponse.setList(memberVoList);
        pageResponse.setPageIndex(pageIndex);
        pageResponse.setTotalSize(memberMapper.MemberListPagingQueryCount(name, integrals, gender, memberName));
        return pageResponse;
    }

}
