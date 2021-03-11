package com.emall.emallgoodsservice.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.emall.emallgoodsentity.entity.po.MemberPricePo;
import com.emall.emallgoodsentity.entity.vo.MemberPriceVo;

import java.util.List;


/**
 * <p>
 * 会员价格 服务类
 * </p>
 *
 * @author qinlang
 * @since 2021-02-03
 */
public interface IMemberPriceService extends IService<MemberPricePo> {

    IPage<MemberPriceVo> memberPriceList(Page page);

    boolean insertMemberPrice(MemberPricePo toPo);

    boolean deleteMemberPrice(Long id);

    boolean updateMemberPrice(MemberPricePo toPo);

    List<MemberPricePo> selectMemberPriceByProductId(Long productId);
}
