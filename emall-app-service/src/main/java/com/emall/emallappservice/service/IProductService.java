package com.emall.emallappservice.service;

import com.emall.emallappservice.entity.params.ProductEsParam;
import com.emall.emallappservice.entity.vo.NewGoodsVo;
import com.emall.emallappservice.entity.vo.PromotionVo;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IProductService {

    /**
     * ES——关键字(商品名，商品副标题，商品标题)查询商品
     * @param productEsParam()
     * @return
     */
    Page getProducts(ProductEsParam productEsParam);

    /**
     * 获取促销商品
     * @return
     */
    List<PromotionVo> getPromotions();

    /**
     * 获取新品商品
     * @return
     */
    List<NewGoodsVo> getNewProducts();
}
