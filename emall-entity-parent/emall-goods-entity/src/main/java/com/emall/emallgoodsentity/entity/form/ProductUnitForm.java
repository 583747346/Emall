package com.emall.emallgoodsentity.entity.form;

import com.emall.emallweb.entity.form.BaseForm;
import com.emall.emallgoodsentity.entity.po.ProductUnitPo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("商品单位表单")
public class ProductUnitForm extends BaseForm<ProductUnitPo> {

    @ApiModelProperty(value = "单位")
    private String unit;

    @ApiModelProperty(value = "状态")
    private Integer status;

}
