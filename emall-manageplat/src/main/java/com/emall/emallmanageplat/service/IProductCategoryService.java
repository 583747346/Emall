package com.emall.emallmanageplat.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.emall.emallmanageplat.entity.params.ProductCatParam;
import com.emall.emallmanageplat.entity.po.ProductCategoryPo;
import com.emall.emallmanageplat.entity.vo.ProductCategoryVo;

import java.util.List;

public interface IProductCategoryService {
    IPage<ProductCategoryVo> getCategory(Page page, ProductCatParam toParam);

    boolean updateProductCatById(ProductCategoryPo productCategoryPo, List<String> catIds);

    boolean deleteProductCatById(String id);

    boolean insertProductCat(ProductCategoryPo toPo, List<String> catIds);

    ProductCategoryVo getAttributeById(String id);
}
