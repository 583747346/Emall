package com.emall.emallmemberservice.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.emall.emallmemberentity.entity.po.MemberRankPo;
import com.emall.emallmemberentity.entity.vo.MemberRankVo;

import java.util.List;

/**
 * <p>
 * 会员等级 服务类
 * </p>
 *
 * @author qinlang
 * @since 2021-02-03
 */
public interface IMemberRankService extends IService<MemberRankPo> {

    IPage<MemberRankVo> memberRankList(Page page);

    Boolean insertMemberRank(MemberRankPo toPo);

    Boolean deleteMemberRank(Long id);

    Boolean updateMemberRank(MemberRankPo toPo);

    Boolean updateStatusById(Long id, Integer status);

    List<String> memberRankeDistinct();
}
