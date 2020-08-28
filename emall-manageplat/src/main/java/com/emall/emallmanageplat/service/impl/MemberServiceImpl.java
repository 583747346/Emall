package com.emall.emallmanageplat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.emallmanageplat.entity.params.MemberQueryParam;
import com.emall.emallweb.entity.po.MemberPo;
import com.emall.emallmanageplat.entity.vo.MemberVo;
import com.emall.emallmanageplat.mapper.MemberMapper;
import com.emall.emallmanageplat.service.IMemberService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, MemberPo> implements IMemberService {

    /**
     * 获取会员的信息
     * @param memberQueryParam
     * @return
     */
    @Override
    public IPage<MemberVo> getMembers(MemberQueryParam memberQueryParam) {
        QueryWrapper<MemberPo> queryWrapper = new QueryWrapper();
        queryWrapper.eq(StringUtils.isNotEmpty(memberQueryParam.getLevelName()),"level_name",memberQueryParam.getLevelName());
        IPage<MemberPo> page = this.page(memberQueryParam.getPage(), queryWrapper);
        return page.convert(MemberVo::new);
    }
}
