package com.emall.emallmanageplat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.emallmanageplat.entity.params.ProductCatParam;
import com.emall.emallweb.entity.po.ProductCategoryPo;
import com.emall.emallmanageplat.entity.vo.ProductCategoryVo;
import com.emall.emallmanageplat.mapper.ProductCategoryMapper;
import com.emall.emallmanageplat.service.IProductCategoryService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

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
    public IPage<ProductCategoryVo> getCategory(Page page, ProductCatParam productCatParam) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq(StringUtils.isNotEmpty(productCatParam.getName()), "name", productCatParam.getName());
        queryWrapper.ge(productCatParam.getCreatedTimeStart() != null, "created_time", productCatParam.getCreatedTimeStart());
        queryWrapper.le(productCatParam.getCreatedTimeEnd() != null, "created_time", productCatParam.getCreatedTimeEnd());
        IPage<ProductCategoryPo> iPage = this.page(page, queryWrapper);
        return iPage.convert(ProductCategoryVo::new);
    }

    /**
     * 根据id更新商品分类信息
     *
     * @param productCategoryPo
     * @param catIds
     * @return
     */
    @Override
    public boolean updateProductCatById(ProductCategoryPo productCategoryPo, List<String> catIds) {
        boolean flag = this.updateById(productCategoryPo);
        //更新分类子级
        List<ProductCategoryPo> poList = null;
        if (productCategoryPo.getLevel() == 1) {
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.notIn("parent_id", String.join(",", catIds));
            this.remove(queryWrapper);
        }
        return flag;
    }

    /**
     * 根据id删除商品分类信息
     *
     * @param id
     * @return
     */
    @Override
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
     * @param catIds
     * @return
     */
    @Override
    public boolean insertProductCat(ProductCategoryPo productCategoryPo, List<String> catIds) {
        //插入父分类信息
        boolean flag = this.save(productCategoryPo);
        //如果此节点是父分类，则保存其子分类信息
        if (productCategoryPo.getLevel() == 1 && catIds.size() > 0) {
            List<ProductCategoryPo> pos = this.baseMapper.selectBatchIds(catIds);
            pos.stream().forEach(po -> po.setParentId(productCategoryPo.getId()));
            this.saveBatch(pos);
        }
        return flag;
    }

    /**
     * 查询此商品分类id的详细信息
     *
     * @param id
     * @return
     */
    @Override
    public ProductCategoryVo getAttributeById(String id) {
        ProductCategoryPo po = this.getById(id);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("parent_id", id);
        List<ProductCategoryPo> pos = this.list(queryWrapper);
        ProductCategoryVo productCategoryVo = new ProductCategoryVo(po);
        List<ProductCategoryVo> vos = pos.stream().map(productCategoryPo -> new ProductCategoryVo(productCategoryPo)).collect(Collectors.toList());
        //组装子分类到Vo
        productCategoryVo.setProductCategoryVos(vos);
        return productCategoryVo;
    }
}
