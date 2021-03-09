package com.emall.emallmemberservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.emallmemberentity.entity.params.MemberPageParam;
import com.emall.emallmemberentity.entity.po.MemberPo;
import com.emall.emallmemberentity.entity.vo.MemberVo;
import com.emall.emallmemberservice.mapper.MemberMapper;
import com.emall.emallmemberservice.service.IMemberService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, MemberPo> implements IMemberService {

    /**
     * 获取会员的信息
     *
     * @param memberQueryParam
     * @return
     */
    @Override
    public IPage<MemberVo> memberList(MemberPageParam memberQueryParam) {
        QueryWrapper<MemberPo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(StringUtils.isNotEmpty(memberQueryParam.getLevelName()), "level_name", memberQueryParam.getLevelName());
        queryWrapper.eq(memberQueryParam.getStatus() != null, "status", memberQueryParam.getStatus());
        IPage<MemberPo> page = this.page(memberQueryParam.getPage(), queryWrapper);
        return page.convert(MemberVo::new);
    }

    /**
     * 根据会员id修改会员状态
     *
     * @param id
     * @param status
     * @return
     */
    @Override
    public boolean updateMemberStatus(Long id, Integer status) {
        UpdateWrapper<MemberPo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", id).set("status", status);
        return this.update(updateWrapper);
    }
}
