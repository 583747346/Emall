package com.emall.emallmanageplat.entity.params;

import com.emall.emallcommon.web.entity.params.BaseParam;
import com.emall.emallmanageplat.entity.po.ProductAttributeValuePo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("商品属性值查询参数")
public class ProductAttValParam extends BaseParam<ProductAttributeValuePo> {

    @ApiModelProperty(value = "商品属性分类id")
    private String attributeKind;
    @ApiModelProperty(value = "商品属性值id")
    private String attributeVal;

}
