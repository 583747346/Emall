package com.emall.emallgoodsservice.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.emall.emallgoodsentity.entity.params.ProductAttributePageParam;
import com.emall.emallgoodsentity.entity.po.ProductAttributePo;
import com.emall.emallgoodsentity.entity.vo.ProductAttributeValueVo;
import com.emall.emallgoodsentity.entity.vo.ProductAttributeVo;

import java.util.List;

public interface IProductAttributesService {

    IPage<ProductAttributeValueVo> getCategoryAttribute(ProductAttributePageParam productAttributePageParam);

    boolean updateAttributeById(ProductAttributePo productAttributePo);

    boolean deleteAttributeById(String id);

    boolean insertAttributeParamById(Long categoryId, ProductAttributePo toPo);

    boolean updateAttributeStatusById(Long id, Integer status);

    List<ProductAttributeVo> attributeByCategoryId(Long id, Integer type);
}
