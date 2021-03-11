package com.emall.emallgoodsservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.emallgoodsentity.entity.form.ProductSkuForm;
import com.emall.emallgoodsentity.entity.params.ProductSkuParam;
import com.emall.emallgoodsentity.entity.po.ProductPo;
import com.emall.emallgoodsentity.entity.po.ProductSkuPo;
import com.emall.emallgoodsentity.entity.vo.ProductSkuVo;
import com.emall.emallgoodsservice.mapper.ProductSkuMapper;
import com.emall.emallgoodsservice.oss.OssUploadPicture;
import com.emall.emallgoodsservice.service.IProductSkuService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductSkuServiceImpl extends ServiceImpl<ProductSkuMapper, ProductSkuPo> implements IProductSkuService {

    @Autowired
    private OssUploadPicture ossUploadPicture;

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
    @Transactional
    public boolean updateByPid(Long pid, List<ProductSkuForm> skuStockList) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("product_id", pid);
        List<ProductSkuPo> productSkuPos = this.list(queryWrapper);
        productSkuPos.stream().forEach(productSkuPo -> {
            skuStockList.stream().forEach(skuStock -> {
                if (StringUtils.equals(productSkuPo.getSkuCode(), skuStock.getSkuCode())) {
                    BeanUtils.copyProperties(skuStock, productSkuPo);
                }
            });
        });
        return this.updateBatchById(productSkuPos);
    }


    /**
     * 批量保存商品sku数据
     *
     * @param productPo
     * @param skuStockList
     * @return
     */
    @Override
    @Transactional
    public boolean saveAll(ProductPo productPo, List<ProductSkuForm> skuStockList) {
        //form表单转Po实体
        List<ProductSkuPo> productSkuPos = new ArrayList<>();
        skuStockList.stream().forEach(productSkuForm -> {
            ProductSkuPo productSkuPo = productSkuForm.toPo(ProductSkuPo.class);
            productSkuPo.setPicture(String.join(",", productSkuForm.getPicture()));
            productSkuPo.setSpecification(productSkuForm.getSpecification());
            productSkuPo.setProductId(productPo.getId());
            //生成skuCode
            generateSkuCode(productPo, productSkuPo);
            productSkuPos.add(productSkuPo);
        });
        return this.saveBatch(productSkuPos);
    }

    /**
     * 根据商品id获取商品sku信息
     * @param productId
     * @return
     */
    @Override
    public List<ProductSkuPo> getSkuListByProductId(Long productId) {
        QueryWrapper<ProductSkuPo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("product_id",productId);
        return this.list(queryWrapper);
    }

    /**
     * sku码生成
     * TODO 生成规则：
     * *      服装品类：【款号+色号+尺码】
     * *      其他品类：
     *
     * @param productPo
     * @param productSkuPo
     */
    private void generateSkuCode(ProductPo productPo, ProductSkuPo productSkuPo) {
        //根据分类获取规格信息的编码
        productSkuPo.setSkuCode(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddhhmmss"))+Math.round((Math.random() + 1) * 1000));
    }
}
