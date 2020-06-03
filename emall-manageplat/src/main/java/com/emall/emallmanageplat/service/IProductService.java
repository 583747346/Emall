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
    IPage<ProductVo> getProducts(Page page, ProductParam productParam);

    Page getProducts(ProductEsParam productEsParam);

    /**
     * 批量上下架产品
     * @param productId
     * @return
     */
    boolean publishProduct(String productId);

    boolean updateProduct(ProductsPo toPo);

    boolean insertProduct(ProductForm productForm);

    /**
     * 批量删除产品
     * @param productId
     * @return
     */
    boolean deleteProduct(String productId);
}
