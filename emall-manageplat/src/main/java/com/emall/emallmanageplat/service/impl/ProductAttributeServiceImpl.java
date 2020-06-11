package com.emall.emallmanageplat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.emallmanageplat.entity.params.ProductAttributeParam;
import com.emall.emallmanageplat.entity.po.ProductAttributePo;
import com.emall.emallmanageplat.entity.vo.ProductAttributeVo;
import com.emall.emallmanageplat.mapper.ProductAttributeMapper;
import com.emall.emallmanageplat.service.IProductAttributeService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class ProductAttributeServiceImpl extends ServiceImpl<ProductAttributeMapper, ProductAttributePo> implements IProductAttributeService {

    /**
     * 根据属性名、日期查询商品属性的值
     * 分页
     * @param page
     * @param productAttributeParam
     * @return
     */
    @Override
    public IPage<ProductAttributeVo> getAttribute(Page page, ProductAttributeParam productAttributeParam) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.like(StringUtils.isNotEmpty(productAttributeParam.getName()), "name", productAttributeParam.getName());
        queryWrapper.ge(productAttributeParam.getCreatedTimeStart() != null, "created_time", productAttributeParam.getCreatedTimeStart());
        queryWrapper.le(productAttributeParam.getCreatedTimeEnd() != null, "created_time", productAttributeParam.getCreatedTimeEnd());
        return this.page(page, queryWrapper);
    }

    /**
     * 根据商品属性id更新属性信息
     * @param productAttributePo
     * @return
     */
    @Override
    public boolean updateProductAttributeById(ProductAttributePo productAttributePo) {
        return this.updateById(productAttributePo);
    }

    /**
     * 根据商品属性id更新属性信息
     * @param id
     * @return
     */
    @Override
    public boolean deleteProductAttributeById(String id) {
        return this.removeById(id);
    }

    /**
     * 插入新的商品属性
     * @param productAttributePo
     * @return
     */
    @Override
    public boolean insertProductAttribute(ProductAttributePo productAttributePo) {
        return this.save(productAttributePo);
    }
}
