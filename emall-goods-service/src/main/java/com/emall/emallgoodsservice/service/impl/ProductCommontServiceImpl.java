package com.emall.emallgoodsservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.emallgoodsentity.entity.params.ProductCommentQueryParam;
import com.emall.emallgoodsentity.entity.po.ProductCommentPo;
import com.emall.emallgoodsentity.entity.vo.ProductCommentVo;
import com.emall.emallgoodsservice.mapper.ProductCommentMapper;
import com.emall.emallgoodsservice.service.IProductCommontService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class ProductCommontServiceImpl extends ServiceImpl<ProductCommentMapper, ProductCommentPo> implements IProductCommontService {
    /**
     * 根据商品名分页查询其评论信息
     * @param productComment
     * @return
     */
    @Override
    public IPage<ProductCommentVo> getComments(ProductCommentQueryParam productComment) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.like(StringUtils.isNotEmpty(productComment.getProductName()),"product_name",productComment.getProductName());
        IPage<ProductCommentPo> iPage = this.page(productComment.getPage(),queryWrapper);
        return iPage.convert(ProductCommentVo::new);
    }
}
