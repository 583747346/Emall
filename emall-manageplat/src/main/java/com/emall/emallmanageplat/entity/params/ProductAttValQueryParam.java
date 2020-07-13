package com.emall.emallmanageplat.entity.params;

import com.emall.emallweb.entity.params.BaseQueryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("商品属性值筛选条件-分页")
public class ProductAttValQueryParam extends BaseQueryParam<ProductAttValParam> {

    @ApiModelProperty(value = "商品属性分类id")
    private String attributeKind;
    @ApiModelProperty(value = "商品属性值id")
    private String attributeVal;

}
