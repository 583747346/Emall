package com.emall.emallgoodsservice.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.emall.emallgoodsentity.entity.params.ProductCatParam;
import com.emall.emallgoodsentity.entity.po.ProductCategoryPo;
import com.emall.emallgoodsentity.entity.vo.ProductCategoryLevelVo;
import com.emall.emallgoodsentity.entity.vo.ProductCategoryVo;
import java.util.List;

public interface IProductCategoryService {
    IPage<ProductCategoryVo> categoryList(Page page, ProductCatParam toParam);

    boolean updateProductCatById(ProductCategoryPo productCategoryPo);

    boolean deleteProductCatById(String id);

    boolean insertProductCat(ProductCategoryPo productCategoryPo);

    List<ProductCategoryVo> getAttributeById(String id, int level);

    List<ProductCategoryLevelVo> getCategory();

    boolean updateStatusById(Long categoryId, int navStatus);

    ProductCategoryPo getCategoryById(Long productCategoryId);
}
