package com.emall.emallgoodsservice.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.emall.emallgoodsentity.entity.form.ProductForm;
import com.emall.emallgoodsentity.entity.params.ProductParam;
import com.emall.emallgoodsentity.entity.vo.ProductDetailsVo;
import com.emall.emallgoodsentity.entity.vo.ProductVo;

public interface IProductService {
    /**
     * 分页查询产品数
     * @param page
     * @param productParam
     * @return
     */
    IPage<ProductVo> getProductByCondition(IPage page, ProductParam productParam);

    /**
     * 批量上下架产品
     * @param productId
     * @return
     */
    boolean publishProduct(String productId);

    /**
     * 根据id更新商品信息
     * @param productId
     * @param productForm
     * @return
     */
    boolean updateProduct(Long productId, ProductForm productForm);

    /**
     * 添加新产品
     * @param productForm
     * @return
     */
    boolean insertProduct(ProductForm productForm);

    /**
     * 批量删除产品
     * @param productId
     * @return
     */
    boolean deleteProduct(String productId);

    boolean updateProductStatus(Long productId, Integer status, String type);

    ProductDetailsVo getProductDetailsById(Long productId);
}
