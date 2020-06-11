package com.emall.emallmanageplat.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.emall.emallmanageplat.entity.params.ProductAttributeParam;
import com.emall.emallmanageplat.entity.po.ProductAttributePo;
import com.emall.emallmanageplat.entity.vo.ProductAttributeVo;

public interface IProductAttributeService {

    IPage<ProductAttributeVo> getAttribute(Page page, ProductAttributeParam productAttributeParam);

    boolean updateProductAttributeById(ProductAttributePo productAttributePo);

    boolean deleteProductAttributeById(String id);

    boolean insertProductAttribute(ProductAttributePo toPo);
}
