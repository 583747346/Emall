package com.emall.emallmemberservice.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.emall.emallmemberentity.entity.params.MemberPageParam;
import com.emall.emallmemberentity.entity.vo.MemberVo;


public interface IMemberService {
    IPage<MemberVo> memberList(MemberPageParam param);

    boolean updateMemberStatus(Long id, Integer status);
}
