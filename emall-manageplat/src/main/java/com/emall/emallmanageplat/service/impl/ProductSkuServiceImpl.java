package com.emall.emallmanageplat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.emallmanageplat.entity.form.ProductSkuForm;
import com.emall.emallmanageplat.entity.params.ProductSkuParam;
import com.emall.emallmanageplat.entity.po.ProductSkuPo;
import com.emall.emallmanageplat.entity.vo.ProductSkuVo;
import com.emall.emallmanageplat.mapper.ProductSkuMapper;
import com.emall.emallmanageplat.service.IProductSkuService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductSkuServiceImpl extends ServiceImpl<ProductSkuMapper, ProductSkuPo> implements IProductSkuService {

    /**
     * 根据商品id获取商品sku信息
     *
     * @param page
     * @param skuParam
     * @return
     */
    @Override
    public IPage<ProductSkuVo> getProductSku(Page page, ProductSkuParam skuParam) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq(StringUtils.isNotEmpty(skuParam.getProductId()), "product_id", skuParam.getProductId());
        IPage<ProductSkuPo> iPage = this.page(page, queryWrapper);
        return iPage.convert(ProductSkuVo::new);
    }

    /**
     * 根据商品id批量更新库存信息
     *
     * @param pid
     * @param skuStockList
     * @return
     */
    @Override
    public boolean updateByPid(String pid, List<ProductSkuForm> skuStockList) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("product_id", pid);
        List<ProductSkuPo> productSkuPos = this.list(queryWrapper);
        productSkuPos.stream().forEach(productSkuPo -> {
            skuStockList.stream().forEach(skuStock -> {
                if (StringUtils.equals(productSkuPo.getId(), skuStock.getSkuid())) {
                    productSkuPo.setStock(skuStock.getStock());
                }
            });
        });
        return this.updateBatchById(productSkuPos);
    }
}
