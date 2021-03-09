package com.emall.emallgoodsservice.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.emall.emallgoodsentity.entity.po.ProductUnitPo;
import com.emall.emallgoodsentity.entity.vo.ProductUnitVo;

/**
 * <p>
 * 商品单位 服务类
 * </p>
 *
 * @author qinlang
 * @since 2021-02-04
 */
public interface IProductUnitService extends IService<ProductUnitPo> {

    IPage<ProductUnitVo> productUnitList(Page page);

    boolean insertProductUnit(ProductUnitPo toPo);

    boolean deleteProductUnit(Long id);

    boolean updateProductUnit(ProductUnitPo toPo);

    boolean updateStatusById(Long id, Integer status);
}
