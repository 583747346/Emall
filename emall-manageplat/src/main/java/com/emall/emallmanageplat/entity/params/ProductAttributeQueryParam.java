package com.emall.emallmanageplat.entity.params;

import com.emall.emallcommon.web.entity.params.BaseParam;
import com.emall.emallcommon.web.entity.params.BaseQueryParam;
import com.emall.emallmanageplat.entity.po.ProductAttributePo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("商品属性筛选参数-分页")
public class ProductAttributeQueryParam extends BaseQueryParam<ProductAttributeParam> {

    @ApiModelProperty(value = "属性名")
    private String name;

}
