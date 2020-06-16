package com.emall.emallmanageplat.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.emall.emallmanageplat.entity.params.MemberQueryParam;
import com.emall.emallmanageplat.entity.vo.MemberVo;

public interface IMemberService {
    IPage<MemberVo> getMembers(MemberQueryParam param);
}
