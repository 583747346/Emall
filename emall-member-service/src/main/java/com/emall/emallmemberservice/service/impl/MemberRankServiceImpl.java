package com.emall.emallmemberservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.emallmemberentity.entity.po.MemberRankPo;
import com.emall.emallmemberentity.entity.vo.MemberRankVo;
import com.emall.emallmemberservice.mapper.MemberRankMapper;
import com.emall.emallmemberservice.service.IMemberRankService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 会员等级 服务实现类
 * </p>
 *
 * @author qinlang
 * @since 2021-02-03
 */
@Service
public class MemberRankServiceImpl extends ServiceImpl<MemberRankMapper, MemberRankPo> implements IMemberRankService {

    @Override
    public IPage<MemberRankVo> memberRankList(Page page) {
        IPage<MemberRankPo> iPage = this.page(page);
        return iPage.convert(MemberRankVo::new);
    }

    @Override
    @Transactional
    public Boolean insertMemberRank(MemberRankPo memberRankPo) {
        return this.save(memberRankPo);
    }

    @Override
    @Transactional
    public Boolean deleteMemberRank(Long id) {
        return this.removeById(id);
    }

    @Override
    @Transactional
    public Boolean updateMemberRank(MemberRankPo memberRankPo) {
        return this.updateById(memberRankPo);
    }

    @Override
    @Transactional
    public Boolean updateStatusById(Long id, Integer status) {
        UpdateWrapper<MemberRankPo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", id).set("status", status);
        return this.update(updateWrapper);
    }

    @Override
    public List<String> memberRankeDistinct() {
        QueryWrapper<MemberRankPo> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("distinct rank");
        queryWrapper.eq("status", 1);
        List<MemberRankPo> memberRankPos = this.baseMapper.selectList(queryWrapper);
        return memberRankPos.stream().map(memberRankPo -> memberRankPo.getRank()).collect(Collectors.toList());
    }
}
