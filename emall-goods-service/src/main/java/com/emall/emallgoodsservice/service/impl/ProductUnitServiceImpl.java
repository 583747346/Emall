package com.emall.emallgoodsservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.emallgoodsentity.entity.po.ProductUnitPo;
import com.emall.emallgoodsentity.entity.vo.ProductUnitVo;
import com.emall.emallgoodsservice.mapper.ProductUnitMapper;
import com.emall.emallgoodsservice.service.IProductUnitService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 商品单位 服务实现类
 * </p>
 *
 * @author qinlang
 * @since 2021-02-04
 */
@Service
public class ProductUnitServiceImpl extends ServiceImpl<ProductUnitMapper, ProductUnitPo> implements IProductUnitService {

    @Override
    public IPage<ProductUnitVo> productUnitList(Page page) {
        IPage<ProductUnitPo> iPage = this.page(page);
        return iPage.convert(ProductUnitVo::new);
    }

    @Override
    @Transactional
    public boolean insertProductUnit(ProductUnitPo productUnitPo) {
        return this.save(productUnitPo);
    }

    @Override
    @Transactional
    public boolean deleteProductUnit(Long id) {
        return this.removeById(id);
    }

    @Override
    @Transactional
    public boolean updateProductUnit(ProductUnitPo productUnitPo) {
        return this.updateById(productUnitPo);
    }

    @Override
    @Transactional
    public boolean updateStatusById(Long id, Integer status) {
        UpdateWrapper<ProductUnitPo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", id).set("status", status);
        return this.update(updateWrapper);
    }
}
