package com.emall.emallmanageplat.entity.form;

import com.emall.emallweb.entity.form.BaseForm;
import com.emall.emallmanageplat.entity.po.ProductAttributeValuePo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("商品属性值插入表单")
public class ProductAttValInsertForm extends BaseForm<ProductAttributeValuePo> {

    @ApiModelProperty(value = "商品属性分类id")
    private String attributeKind;
    @ApiModelProperty(value = "商品属性值id")
    private String attributeVal;
    @ApiModelProperty(value = "商品属性值描述")
    private String value;

}
