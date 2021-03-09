package com.emall.emallgoodsservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.emallgoodsentity.entity.params.ProductCatParam;
import com.emall.emallgoodsentity.entity.po.ProductCategoryPo;
import com.emall.emallgoodsentity.entity.vo.ProductCategoryLevelVo;
import com.emall.emallgoodsentity.entity.vo.ProductCategoryVo;
import com.emall.emallgoodsservice.mapper.ProductCategoryMapper;
import com.emall.emallgoodsservice.service.IProductCategoryService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductCategoryServiceImpl extends ServiceImpl<ProductCategoryMapper, ProductCategoryPo> implements IProductCategoryService {
    /**
     * 条件查询商品分类信息
     * 分页
     *
     * @param page
     * @param productCatParam
     * @return
     */
    @Override
    public IPage<ProductCategoryVo> categoryList(Page page, ProductCatParam productCatParam) {
        QueryWrapper queryWrapper = productCatParam.build();
        queryWrapper.eq(StringUtils.isNotEmpty(productCatParam.getName()), "name", productCatParam.getName());
        //显示一级
        queryWrapper.eq("level", 1);
        queryWrapper.eq(productCatParam.getParentId() != null, "parent_id", productCatParam.getParentId());
        IPage<ProductCategoryPo> iPage = this.page(page, queryWrapper);
        return iPage.convert(ProductCategoryVo::new);
    }

    /**
     * 根据id更新商品分类信息
     *
     * @param productCategoryPo
     * @return
     */
    @Override
    @Transactional
    public boolean updateProductCatById(ProductCategoryPo productCategoryPo) {
        return this.updateById(productCategoryPo);
    }

    /**
     * 根据id删除商品分类信息
     *
     * @param id
     * @return
     */
    @Override
    @Transactional
    public boolean deleteProductCatById(String id) {
        //删除父分类
        boolean flag = this.removeById(id);
        //删除此id父分类下面的子分类
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("parent_id", id);
        return this.remove(queryWrapper);
    }

    /**
     * 插入新的分类
     *
     * @param productCategoryPo
     * @return
     */
    @Override
    @Transactional
    public boolean insertProductCat(ProductCategoryPo productCategoryPo) {
        //插入父分类信息
        return this.save(productCategoryPo);
    }

    /**
     * 查询此商品分类id的详细信息
     *
     * @param id
     * @return
     */
    @Override
    public List<ProductCategoryVo> getAttributeById(String id, int level) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("parent_id", id);
        queryWrapper.eq("level", level);
        List<ProductCategoryPo> pos = this.list(queryWrapper);
        List<ProductCategoryVo> vos = pos.stream().map(productCategoryPo -> new ProductCategoryVo(productCategoryPo)).collect(Collectors.toList());
        return vos;
    }

    /**
     * 获取分类层级，
     * 1.用于商品分类列表查询条件
     * 2.商品创建时的分类选择
     *
     * @return
     */
    @Override
    public List<ProductCategoryLevelVo> getCategory() {
        List<ProductCategoryPo> categoryPos = this.list();
        List<ProductCategoryLevelVo> productCategoryVos = categoryPos.stream()
                .filter(productCategoryPo -> productCategoryPo.getParentId() == 0L)
                .map(productCategoryVo -> convert(productCategoryVo, categoryPos)).collect(Collectors.toList());
        return productCategoryVos;
    }

    /**
     * 根据分类id更新状态
     *
     * @param categoryId
     * @param navStatus
     * @return
     */
    @Override
    @Transactional
    public boolean updateStatusById(Long categoryId, int navStatus) {
        UpdateWrapper<ProductCategoryPo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", categoryId).set("nav_status", navStatus);
        return this.update(updateWrapper);
    }

    /**
     * 根据分类id获取分类信息
     * @param productCategoryId
     * @return
     */
    @Override
    public ProductCategoryPo getCategoryById(Long productCategoryId) {
        return this.getById(productCategoryId);
    }

    public ProductCategoryLevelVo convert(ProductCategoryPo productCategoryPo, List<ProductCategoryPo> categoryPos) {
        ProductCategoryLevelVo levelVo = new ProductCategoryLevelVo();
        BeanUtils.copyProperties(productCategoryPo, levelVo);
        List<ProductCategoryPo> pos = categoryPos.stream()
                .filter(categoryPo -> categoryPo.getParentId().equals(productCategoryPo.getId()))
                .collect(Collectors.toList());
        if (pos.size() != 0) {
            levelVo.setChildren(pos);
        }
        return levelVo;
    }
}
