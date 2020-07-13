package com.emall.emallmanageplat.entity.params;

import com.emall.emallweb.entity.params.BaseParam;
import com.emall.emallmanageplat.entity.po.ProductAttributePo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("商品属性查询参数")
public class ProductAttributeParam extends BaseParam<ProductAttributePo> {

    @ApiModelProperty(value = "属性名")
    private String name;

}
