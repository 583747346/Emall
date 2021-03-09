package com.emall.emallgoodsservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.emallgoodsentity.entity.params.ProductAttributePageParam;
import com.emall.emallgoodsentity.entity.po.ProductAttributePo;
import com.emall.emallgoodsentity.entity.vo.ProductAttributeValueVo;
import com.emall.emallgoodsentity.entity.vo.ProductAttributeVo;
import com.emall.emallgoodsservice.mapper.ProductAttributeMapper;
import com.emall.emallgoodsservice.service.ICategoryAttributeService;
import com.emall.emallgoodsservice.service.IProductAttributesService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductAttributesServiceImpl extends ServiceImpl<ProductAttributeMapper, ProductAttributePo> implements IProductAttributesService {

    @Autowired
    private ICategoryAttributeService categoryAttributeService;

    /**
     * 根据属性名、日期查询商品属性的值
     * 分页
     *
     * @param productAttributePageParam
     * @return
     */
    @Override
    public IPage<ProductAttributeValueVo> getCategoryAttribute(ProductAttributePageParam productAttributePageParam) {
        QueryWrapper<ProductAttributeValueVo> queryWrapper = new QueryWrapper();
        queryWrapper.like(StringUtils.isNotEmpty(productAttributePageParam.getName()), "name", productAttributePageParam.getName());
        queryWrapper.select("epc.id,epc.name,count( case when epa.type = 0 then epa.name end ) as specsNum,count( case when epa.type = 1 then epa.name end ) AS paramNum ");
        queryWrapper.groupBy("epc.id,epc.NAME");
        IPage<ProductAttributeValueVo> productAttributValueVo = this.baseMapper.getCategoryAttribute(productAttributePageParam.getPage(), queryWrapper);
        return productAttributValueVo;
    }

    /**
     * 根据商品属性id更新属性信息
     *
     * @param productAttributePo
     * @return
     */
    @Override
    public boolean updateAttributeById(ProductAttributePo productAttributePo) {
        return this.updateById(productAttributePo);
    }

    /**
     * 根据商品属性id更新属性信息
     *
     * @param id
     * @return
     */
    @Override
    @Transactional
    public boolean deleteAttributeById(String id) {
        return this.removeById(id);
    }

    /**
     * 插入新的商品属性
     *
     * @param categoryId
     * @param productAttributePo
     * @return
     */
    @Override
    @Transactional
    public boolean insertAttributeParamById(Long categoryId, ProductAttributePo productAttributePo) {
        boolean attribute = this.save(productAttributePo);
        //添加品类与属性的关联
        boolean categoryAttribute = categoryAttributeService.saveCategoryAttribute(categoryId, productAttributePo.getId());
        return attribute && categoryAttribute;
    }

    @Override
    @Transactional
    public boolean updateAttributeStatusById(Long id, Integer status) {
        UpdateWrapper<ProductAttributePo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", id).set("status", status);
        return this.update(updateWrapper);
    }

    /**
     * 根据分类id获取 属性规格 | 属性参数
     *
     * @param id
     * @param type
     * @return
     */
    @Override
    public List<ProductAttributeVo> attributeByCategoryId(Long id, Integer type) {
        QueryWrapper<ProductAttributePo> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("epa.id,name,attribute_list,status");
        queryWrapper.eq("ecar.product_category_id", id);
        queryWrapper.eq("epa.type", type);
        List<ProductAttributePo> productAttributePo = this.baseMapper.attributeByCategoryId(queryWrapper);
        List<ProductAttributeVo> productAttributeVos = productAttributePo.stream().map(po -> new ProductAttributeVo(po)).collect(Collectors.toList());
        return productAttributeVos;
    }
}
