package com.emall.emallgoodsservice.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.emall.emallgoodsentity.entity.form.ProductSkuForm;
import com.emall.emallgoodsentity.entity.params.ProductSkuParam;
import com.emall.emallgoodsentity.entity.po.ProductPo;
import com.emall.emallgoodsentity.entity.vo.ProductSkuVo;

import java.util.List;

public interface IProductSkuService {
    IPage<ProductSkuVo> getProductSku(Page page, ProductSkuParam toParam);

    boolean updateByPid(Long pid, List<ProductSkuForm> skuStockList);

    boolean saveAll(ProductPo productPo, List<ProductSkuForm> skuStockList);
}
