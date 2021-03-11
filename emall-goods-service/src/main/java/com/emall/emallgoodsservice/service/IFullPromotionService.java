package com.emall.emallgoodsservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.emall.emallgoodsentity.entity.po.FullPromotionPo;

import java.util.List;

/**
 * <p>
 * 满减促销表 服务类
 * </p>
 *
 * @author qinlang
 * @since 2021-02-25
 */
public interface IFullPromotionService extends IService<FullPromotionPo> {

    List<FullPromotionPo> selectFullPromotionByProductId(Long productId);
}
