package com.emall.emallgoodsentity.entity.form;

import com.emall.emallgoodsentity.entity.po.ProductAttributePo;
import com.emall.emallweb.entity.form.BaseForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("商品属性更新表单")
public class ProductAttributeUpdateForm extends BaseForm<ProductAttributePo> {

    @ApiModelProperty(value = "商品属性名",name = "name")
    private String name;
    @ApiModelProperty(value = "属性类型(0-规格,1-参数)",name = "type")
    private Integer type;
    @ApiModelProperty(value = "属性列表(规格|参数)")
    private String attributeList;
    @ApiModelProperty(value = "属性状态(0-禁用,1-启用)",name = "status")
    private Integer status;
}
