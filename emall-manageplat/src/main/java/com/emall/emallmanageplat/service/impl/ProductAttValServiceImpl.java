package com.emall.emallmanageplat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.emallmanageplat.entity.params.ProductAttValParam;
import com.emall.emallweb.entity.po.ProductAttributeValuePo;
import com.emall.emallmanageplat.entity.vo.ProductAttributeValueVo;
import com.emall.emallmanageplat.mapper.ProductAttValMapper;
import com.emall.emallmanageplat.service.IProductAttValService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class ProductAttValServiceImpl extends ServiceImpl<ProductAttValMapper, ProductAttributeValuePo> implements IProductAttValService {

    /**
     * 根据属性id、属性分类查询属性值（商品规格）
     *
     * @param page
     * @param param
     * @return
     */
    @Override
    public IPage<ProductAttributeValueVo> getAttributeVal(Page page, ProductAttValParam param) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq(StringUtils.isNotEmpty(param.getAttributeKind()), "product_attribute_category_id", param.getAttributeKind());
        queryWrapper.eq(StringUtils.isNotEmpty(param.getAttributeVal()), "product_attribute_id", param.getAttributeVal());
        queryWrapper.ge(param.getCreatedTimeStart() != null, "created_time", param.getCreatedTimeStart());
        queryWrapper.le(param.getCreatedTimeEnd() != null, "created_time", param.getCreatedTimeEnd());
        return this.page(page, queryWrapper);
    }

    /**
     * 根据id删除对应属性值记录
     * @param id
     * @return
     */
    @Override
    public boolean deleteProductAttValById(String id) {
        return this.removeById(id);
    }

    /**
     * 根据id更新商品属性的值
     * @param productAttributeValuePo
     * @return
     */
    @Override
    public boolean updateProductAttributeById(ProductAttributeValuePo productAttributeValuePo) {
        return this.updateById(productAttributeValuePo);
    }

    /**
     * 插入新的商品属性值
     * @param productAttributeValuePo
     * @return
     */
    @Override
    public boolean insertProductAttVal(ProductAttributeValuePo productAttributeValuePo) {
        return this.save(productAttributeValuePo);
    }

}
