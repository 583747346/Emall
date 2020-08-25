package com.emall.emallmanageplat.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.emall.emallmanageplat.entity.form.ProductForm;
import com.emall.emallmanageplat.entity.params.ProductEsParam;
import com.emall.emallmanageplat.entity.params.ProductParam;
import com.emall.emallmanageplat.entity.po.ProductsPo;
import com.emall.emallmanageplat.entity.vo.ProductVo;
import org.springframework.data.domain.Page;

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

    /**
     * ES——关键字(商品名，商品副标题，商品标题)查询商品
     * @param productEsParam()
     * @return
     */
    Page getProducts(ProductEsParam productEsParam);

}
