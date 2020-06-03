package com.emall.emallmanageplat.entity.vo;

import com.emall.emallcommon.web.entity.vo.BaseVo;
import com.emall.emallmanageplat.entity.po.ProductsPo;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel("产品信息视图")
public class ProductVo extends BaseVo<ProductsPo> {
}
