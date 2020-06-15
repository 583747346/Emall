package com.emall.emallmanageplat.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.emall.emallmanageplat.entity.params.ProductCommentQueryParam;
import com.emall.emallmanageplat.entity.vo.ProductCommentVo;

public interface IProductCommontService {
    IPage<ProductCommentVo> getComments(ProductCommentQueryParam param);
}
