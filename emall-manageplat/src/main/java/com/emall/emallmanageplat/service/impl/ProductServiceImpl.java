package com.emall.emallmanageplat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.emallmanageplat.entity.params.ProductEsParam;
import com.emall.emallmanageplat.entity.params.ProductParam;
import com.emall.emallmanageplat.entity.po.ProductsPo;
import com.emall.emallmanageplat.entity.vo.ProductVo;
import com.emall.emallmanageplat.mapper.ESProductMapper;
import com.emall.emallmanageplat.mapper.ProductMapper;
import com.emall.emallmanageplat.service.IProductService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper,ProductsPo> implements IProductService {

    @Autowired
    private ESProductMapper esProductMapper;

    @Override
    public IPage<ProductVo> getResourceByCondition(IPage page, ProductParam productParam) {
        QueryWrapper queryWrapper = new QueryWrapper();
        //TODO 查询产品的时候筛选品牌/类别 表结构的关联
        queryWrapper.like(StringUtils.isNotEmpty(productParam.getName()),"name",productParam.getName());
        queryWrapper.eq(StringUtils.isNotEmpty(productParam.getBrand()),"brand",productParam.getBrand());
        queryWrapper.eq(StringUtils.isNotEmpty(productParam.getProductCategory()),"category",productParam.getProductCategory());
        queryWrapper.ge(StringUtils.isNotEmpty(productParam.getCreatedTimeStart().toString()),"created_time",productParam.getCreatedTimeStart());
        queryWrapper.le(StringUtils.isNotEmpty(productParam.getCreatedTimeEnd().toString()),"created_time",productParam.getCreatedTimeEnd());
        IPage<ProductsPo> productsPos = this.page(page,queryWrapper);
        return productsPos.convert(ProductVo::new);
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

    /**
     * 根据产品id更新商品信息
     * @param productsPo
     * @return
     */
    @Override
    public boolean updateProduct(ProductsPo productsPo) {
        return this.updateById(productsPo);
    }

    /**
     * 添加新产品
     * @param productPo
     * @return
     */
    @Override
    public boolean insertProduct(ProductsPo productPo) {
        return this.save(productPo);
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

    /**
     * 根据产品名、品牌、产品类别查询商品
     * @param productEsParam
     * @return
     */
    @Override
    public Page<ProductVo> getProducts(ProductEsParam productEsParam) {
        Pageable pageable = PageRequest.of(productEsParam.getCurrent() - 1,(int)productEsParam.getSize());
        Page<ProductsPo> page = esProductMapper.findByNameOrSubTitleOrDetailsTitle(productEsParam.getKey(),productEsParam.getKey(),productEsParam.getKey(),pageable);
        List<ProductVo> productVos = new ArrayList<>();
        page.getContent().forEach(productsPo -> {
            ProductVo productVo = new ProductVo();
            productVo.toVo(productsPo);
            productVos.add(productVo);
        });
        return new PageImpl<ProductVo>(productVos, pageable, productVos.size());
    }
}
