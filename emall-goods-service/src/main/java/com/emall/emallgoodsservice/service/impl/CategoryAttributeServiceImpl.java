package com.emall.emallgoodsservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.emallgoodsentity.entity.po.CategoryAttributePo;
import com.emall.emallgoodsservice.mapper.CategoryAttributeMapper;
import com.emall.emallgoodsservice.service.ICategoryAttributeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryAttributeServiceImpl extends ServiceImpl<CategoryAttributeMapper, CategoryAttributePo> implements ICategoryAttributeService {
    @Override
    @Transactional
    public boolean saveCategoryAttribute(Long categoryId, Long id) {
        CategoryAttributePo po = new CategoryAttributePo();
        po.setProductCategoryId(categoryId);
        po.setProductAttributeId(id);
        return this.save(po);
    }
}
