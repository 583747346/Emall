package com.emall.emallmanageplat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.emallmanageplat.entity.form.ProductForm;
import com.emall.emallmanageplat.entity.params.ProductEsParam;
import com.emall.emallmanageplat.entity.params.ProductParam;
import com.emall.emallmanageplat.entity.po.ProductsPo;
import com.emall.emallmanageplat.entity.vo.ProductVo;
import com.emall.emallmanageplat.mapper.ESProductMapper;
import com.emall.emallmanageplat.mapper.ProductMapper;
import com.emall.emallmanageplat.service.IProductService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper,ProductsPo> implements IProductService {

    @Autowired
    private ESProductMapper productMapper;

    /**
     * 根据产品名、品牌、产品类别查询商品
     * @param page
     * @param productParam
     * @return
     */
    @Override
    public IPage<ProductVo> getProducts(Page page, ProductParam productParam) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.like(StringUtils.equals(productParam.getName(),""),"name",productParam.getName());
        queryWrapper.eq(StringUtils.equals(productParam.getBrand(),""),"",productParam.getBrand());
        queryWrapper.eq(StringUtils.equals(productParam.getProductCategory(),""),"",productParam.getProductCategory());
        return null;
    }

    @Override
    public Page<ProductVo> getProducts(ProductEsParam productEsParam) {
        Pageable pageable = PageRequest.of(productEsParam.getCurrent() - 1,(int)productEsParam.getSize());
        Page<ProductsPo> page = productMapper.findByNameOrSubTileOrDetailsTitle(productEsParam.getKey(),productEsParam.getKey(),productEsParam.getKey());
        return null;
    }

    /**
     * 批量上下架产品
     * @param productIds
     * @return
     */
    @Override
    public boolean publishProduct(String productIds) {
        List<String> ids = Arrays.asList(productIds.split(","));
        List<ProductsPo> poList = this.baseMapper.selectBatchIds(ids);
        poList.forEach(productsPo -> {
            productsPo.setPublishStatus("1");
        });
        return this.updateBatchById(poList);
    }

    @Override
    public boolean updateProduct(ProductsPo toPo) {
        return false;
    }

    @Override
    public boolean insertProduct(ProductForm productForm) {
        return false;
    }

    /**
     * 根据id批量删除产品信息
     * @param productIds
     * @return
     */
    @Override
    public boolean deleteProduct(String productIds) {
        List<String> ids = Arrays.asList(productIds.split(","));
        List<ProductsPo> poList = this.baseMapper.selectBatchIds(ids);
        poList.forEach(productsPo -> {
            productsPo.setDeleteStatus("1");
        });
        return this.updateBatchById(poList);
    }
}
