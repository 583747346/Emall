package com.emall.emallappservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.emallcore.result.Result;
import com.emall.emallappservice.entity.form.MemberForm;
import com.emall.emallappservice.entity.po.MemberPo;
import com.emall.emallappservice.entity.vo.MemberVo;
import com.emall.emallappservice.mapper.MemberMapper;
import com.emall.emallappservice.service.IMemberService;
import com.emall.emallweb.context.UserApplicationContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MemberServiceImpl extends ServiceImpl<MemberMapper, MemberPo> implements IMemberService {

    /**
     * 手机号一键登录
     *
     * @param memberForm
     * @return
     */
    @Override
    public Result register(MemberForm memberForm) {
        return null;
    }

    /**
     * 获取用户详情
     *
     * @return
     */
    @Override
    public MemberVo getMemberInfo() {
        String username = UserApplicationContext.getInstance().getUsername();
        //根据用户名获取用户详情
        QueryWrapper<MemberPo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        return new MemberVo(this.baseMapper.selectOne(queryWrapper));
    }

    /**
     * 更新会员信息
     *
     * @return
     */
    @Override
    public MemberVo updateMember() {
        return null;
    }
}
