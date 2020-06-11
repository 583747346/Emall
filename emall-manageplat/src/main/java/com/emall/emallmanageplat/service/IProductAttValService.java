package com.emall.emallmanageplat.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.emall.emallmanageplat.entity.params.ProductAttValParam;
import com.emall.emallmanageplat.entity.po.ProductAttributeValuePo;
import com.emall.emallmanageplat.entity.vo.ProductAttributeValueVo;

public interface IProductAttValService {
    IPage<ProductAttributeValueVo> getAttributeVal(Page page, ProductAttValParam toParam);

    boolean deleteProductAttValById(String id);

    boolean updateProductAttributeById(ProductAttributeValuePo productAttributeValuePo);

    boolean insertProductAttVal(ProductAttributeValuePo productAttributeValuePo);
}
