package com.emall.emallgoodsservice.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.emall.emallgoodsentity.entity.params.ProductCommentQueryParam;
import com.emall.emallgoodsentity.entity.vo.ProductCommentVo;

public interface IProductCommontService {
    IPage<ProductCommentVo> getComments(ProductCommentQueryParam param);
}
