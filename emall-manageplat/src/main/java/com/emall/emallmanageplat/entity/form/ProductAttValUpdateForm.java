package com.emall.emallmanageplat.entity.form;

import com.emall.emallcommon.web.entity.form.BaseForm;
import com.emall.emallmanageplat.entity.po.ProductAttributeValuePo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@ApiModel("商品属性值更新表单")
public class ProductAttValUpdateForm extends BaseForm<ProductAttributeValuePo> {

    @ApiModelProperty(value = "value")
    @NotNull
    private String value;

}
