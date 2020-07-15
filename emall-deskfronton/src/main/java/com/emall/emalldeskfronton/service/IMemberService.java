package com.emall.emalldeskfronton.service;

import com.emall.emallcore.result.Result;
import com.emall.emalldeskfronton.entity.form.MemberForm;
import com.emall.emalldeskfronton.entity.vo.MemberVo;

public interface IMemberService {

    Result register(MemberForm memberForm);

    MemberVo getMemberInfo();

    MemberVo updateMember();
}
