package com.emall.emallappservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.emallappservice.entity.params.ProductEsParam;
import com.emall.emallappservice.entity.vo.NewGoodsVo;
import com.emall.emallappservice.entity.vo.ProductVo;
import com.emall.emallappservice.entity.vo.PromotionVo;
import com.emall.emallappservice.mapper.ESProductMapper;
import com.emall.emallappservice.mapper.ProductMapper;
import com.emall.emallappservice.service.IProductService;
import com.emall.emallgoodsentity.entity.po.ProductPo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, ProductPo> implements IProductService {

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
        Page<ProductPo> page = productMapper.findByNameOrSubTitleOrDetailTitle(productEsParam.getKey(), productEsParam.getKey(), productEsParam.getKey(), pageable);
        List<ProductVo> productVos = new ArrayList<>();
        page.getContent().forEach(productPo -> {
            ProductVo productVo = new ProductVo(productPo);
            productVos.add(productVo);
        });
        return new PageImpl<ProductVo>(productVos, pageable, productVos.size());
    }

    /**
     * 首页，获取促销商品信息
     * @return
     */
    @Override
    public List<PromotionVo> getPromotions() {
        QueryWrapper<ProductPo> queryWrapper = new QueryWrapper<>();
        return null;
    }

    /**
     * 首页，获取新品商品信息
     * @return
     */
    @Override
    public List<NewGoodsVo> getNewProducts() {
        QueryWrapper<ProductPo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("new_status",1);  //状态：新品
        queryWrapper.last("limit 10");//取前面10条数据
        List<ProductPo> productPoList = this.list(queryWrapper);
        //goods结果集转换为新品视图
        List<NewGoodsVo> goodsVos = new ArrayList<>();
        productPoList.stream().forEach(productPo -> {
            NewGoodsVo newGoodsVo = new NewGoodsVo();
            BeanUtils.copyProperties(productPo,newGoodsVo);
            goodsVos.add(newGoodsVo);
        });
        return goodsVos;
    }

}
