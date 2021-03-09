package com.emall.emallgoodsentity.entity.form;

import com.emall.emallweb.entity.form.BaseForm;
import com.emall.emallgoodsentity.entity.po.ProductAttributePo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("商品属性添加表单")
public class ProductAttributeInsertForm extends BaseForm<ProductAttributePo> {

    @ApiModelProperty(value = "属性名")
    private String name;
    @ApiModelProperty(value = "属性类型(0-规格,1-参数)",name = "type")
    private Integer type;
    @ApiModelProperty(value = "属性列表(规格|参数)")
    private String attributeList;
    @ApiModelProperty(value = "品类id")
    private Long categoryId;

}
