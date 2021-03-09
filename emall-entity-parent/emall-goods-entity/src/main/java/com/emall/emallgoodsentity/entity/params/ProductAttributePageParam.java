package com.emall.emallgoodsentity.entity.params;

import com.emall.emallweb.entity.params.BasePageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("商品属性筛选参数-分页")
public class ProductAttributePageParam extends BasePageParam<ProductAttributeParam> {

    @ApiModelProperty(value = "属性名")
    private String name;
    @ApiModelProperty("属性列表(规格|参数)")
    private String attributeList;
    @ApiModelProperty(value = "属性状态(0-禁用,1-启用)")
    private Integer status;
}
