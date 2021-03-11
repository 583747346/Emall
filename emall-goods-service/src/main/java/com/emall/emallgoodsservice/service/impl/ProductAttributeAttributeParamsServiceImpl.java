package com.emall.emallgoodsservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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

    /**
     * 根据商品id查看属性参数
     * @param productId
     * @return
     */
    @Override
    public List<ProductAttributeParamsPo> selectByProductId(Long productId) {
        QueryWrapper<ProductAttributeParamsPo> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("attribute_id,GROUP_CONCAT(attribute_value) as attribute_value");
        queryWrapper.eq("product_id",productId);
        queryWrapper.groupBy("attribute_id");
        return this.list(queryWrapper);
    }
}
