package com.emall.emallgoodsservice.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.emallgoodsentity.entity.po.MemberPricePo;
import com.emall.emallgoodsentity.entity.vo.MemberPriceVo;
import com.emall.emallgoodsservice.mapper.MemberPriceMapper;
import com.emall.emallgoodsservice.service.IMemberPriceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 会员价格 服务实现类
 * </p>
 *
 * @author qinlang
 * @since 2021-02-03
 */
@Service
public class MemberPriceServiceImpl extends ServiceImpl<MemberPriceMapper, MemberPricePo> implements IMemberPriceService {

    @Override
    public IPage<MemberPriceVo> memberPriceList(Page page) {
        IPage<MemberPricePo> iPage = this.page(page);
        return iPage.convert(MemberPriceVo::new);
    }

    @Override
    @Transactional
    public boolean insertMemberPrice(MemberPricePo memberPricePo) {
        return this.save(memberPricePo);
    }

    @Override
    @Transactional
    public boolean deleteMemberPrice(Long id) {
        return this.removeById(id);
    }

    @Override
    @Transactional
    public boolean updateMemberPrice(MemberPricePo memberPricePo) {
        return this.updateById(memberPricePo);
    }
}
