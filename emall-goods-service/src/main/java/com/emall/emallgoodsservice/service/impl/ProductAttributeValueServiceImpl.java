package com.emall.emallgoodsservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.emallgoodsentity.entity.po.ProductAttributeValuePo;
import com.emall.emallgoodsservice.mapper.ProductAttributeValueMapper;
import com.emall.emallgoodsservice.service.IProductAttributeValueService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品属性规格值 服务实现类
 * </p>
 *
 * @author qinlang
 * @since 2021-02-25
 */
@Service
public class ProductAttributeValueServiceImpl extends ServiceImpl<ProductAttributeValueMapper, ProductAttributeValuePo> implements IProductAttributeValueService {

}
