package com.emall.emalldeskfronton.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.emalldeskfronton.entity.params.ProductEsParam;
import com.emall.emalldeskfronton.entity.po.EsProductPo;
import com.emall.emalldeskfronton.entity.vo.ProductVo;
import com.emall.emalldeskfronton.mapper.ESProductMapper;
import com.emall.emalldeskfronton.service.IProductService;
import com.emall.emallweb.entity.po.ProductsPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ESProductMapper productMapper;

    /**
     * 根据产品名、品牌、产品类别查询商品
     *
     * @param productEsParam
     * @return
     */
    @Override
    public Page<ProductVo> getProducts(ProductEsParam productEsParam) {
        Pageable pageable = PageRequest.of(productEsParam.getCurrent() - 1, (int) productEsParam.getSize());
        Page<ProductsPo> page = productMapper.findByNameOrSubTitleOrDetailsTitle(productEsParam.getKey(), productEsParam.getKey(), productEsParam.getKey(), pageable);
        List<ProductVo> productVos = new ArrayList<>();
        page.getContent().forEach(productsPo -> {
            ProductVo productVo = new ProductVo(productsPo);
            productVos.add(productVo);
        });
        return new PageImpl<ProductVo>(productVos, pageable, productVos.size());
    }

}
