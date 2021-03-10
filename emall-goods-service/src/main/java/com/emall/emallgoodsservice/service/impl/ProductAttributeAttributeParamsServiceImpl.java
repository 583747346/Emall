package com.emall.emallgoodsservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.emallgoodsentity.entity.po.ProductAttributeParamsPo;
import com.emall.emallgoodsservice.mapper.ProductAttributeParamsMapper;
import com.emall.emallgoodsservice.service.IProductAttributeParamsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductAttributeAttributeParamsServiceImpl extends ServiceImpl<ProductAttributeParamsMapper, ProductAttributeParamsPo> implements IProductAttributeParamsService {

    /**
     * 批量保存商品属性参数列表
     * @param productAttributeParamsPos
     */
    @Override
    public void insertBatch(List<ProductAttributeParamsPo> productAttributeParamsPos) {
        this.saveBatch(productAttributeParamsPos);
    }
}
