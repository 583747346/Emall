package com.emall.emalldeskfronton.service.impl;

import com.emall.emalldeskfronton.entity.po.MemberPo;
import com.emall.emalldeskfronton.service.IMemberService;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements IMemberService {


    /**
     * 获取当前用户
     * @return
     */
    @Override
    public MemberPo getCurrentUser() {
        //根据token获取用户信息

        return null;
    }
}
