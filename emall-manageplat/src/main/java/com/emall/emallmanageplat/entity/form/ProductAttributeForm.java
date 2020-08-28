package com.emall.emallmanageplat.entity.form;

import com.emall.emallweb.entity.form.BaseForm;
import com.emall.emallweb.entity.po.ProductAttributePo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("商品属性插入&更新表单")
public class ProductAttributeForm extends BaseForm<ProductAttributePo> {

    @ApiModelProperty(value = "商品属性名",name = "name")
    private String name;

}
