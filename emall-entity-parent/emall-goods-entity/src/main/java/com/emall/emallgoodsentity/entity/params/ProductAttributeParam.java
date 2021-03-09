package com.emall.emallgoodsentity.entity.params;

import com.emall.emallgoodsentity.entity.po.ProductAttributePo;
import com.emall.emallweb.entity.params.BaseParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("商品属性查询参数")
public class ProductAttributeParam extends BaseParam<ProductAttributePo> {

    @ApiModelProperty(value = "分类")
    private String name;
    @ApiModelProperty(value = "属性类型(规格|参数)")
    private String type;
}
