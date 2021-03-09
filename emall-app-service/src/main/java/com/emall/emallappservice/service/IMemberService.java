package com.emall.emallappservice.service;

import com.emall.emallcore.result.Result;
import com.emall.emallappservice.entity.form.MemberForm;
import com.emall.emallappservice.entity.vo.MemberVo;

public interface IMemberService {

    Result register(MemberForm memberForm);

    MemberVo getMemberInfo();

    MemberVo updateMember();
}
