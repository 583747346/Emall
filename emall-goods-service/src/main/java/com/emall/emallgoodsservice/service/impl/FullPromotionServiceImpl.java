package com.emall.emallgoodsservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.emallgoodsentity.entity.po.FullPromotionPo;
import com.emall.emallgoodsservice.mapper.PmsFullPromotionMapper;
import com.emall.emallgoodsservice.service.IFullPromotionService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 满减促销表 服务实现类
 * </p>
 *
 * @author qinlang
 * @since 2021-02-25
 */
@Service
public class FullPromotionServiceImpl extends ServiceImpl<PmsFullPromotionMapper, FullPromotionPo> implements IFullPromotionService {

    @Override
    public List<FullPromotionPo> selectFullPromotionByProductId(Long productId) {
        QueryWrapper<FullPromotionPo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("product_id", productId);
        return this.list(queryWrapper);
    }
}
