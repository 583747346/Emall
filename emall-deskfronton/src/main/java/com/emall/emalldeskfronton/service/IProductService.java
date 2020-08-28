package com.emall.emalldeskfronton.service;

import com.emall.emalldeskfronton.entity.params.ProductEsParam;
import org.springframework.data.domain.Page;

public interface IProductService {

    /**
     * ES——关键字(商品名，商品副标题，商品标题)查询商品
     * @param productEsParam()
     * @return
     */
    Page getProducts(ProductEsParam productEsParam);

}
