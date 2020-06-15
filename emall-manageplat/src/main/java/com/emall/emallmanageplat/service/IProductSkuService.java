package com.emall.emallmanageplat.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.emall.emallmanageplat.entity.form.ProductSkuForm;
import com.emall.emallmanageplat.entity.params.ProductSkuParam;
import com.emall.emallmanageplat.entity.vo.ProductSkuVo;

import java.util.List;

public interface IProductSkuService {
    IPage<ProductSkuVo> getProductSku(Page page, ProductSkuParam toParam);

    boolean updateByPid(String pid, List<ProductSkuForm> skuStockList);
}
