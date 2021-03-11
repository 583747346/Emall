package com.emall.emallgoodsservice.service;

import com.emall.emallgoodsentity.entity.po.ProductAttributeParamsPo;

import java.util.List;

public interface IProductAttributeParamsService {
    void insertBatch(List<ProductAttributeParamsPo> productAttributeParamsPos);

    List<ProductAttributeParamsPo> selectByProductId(Long productId);
}
