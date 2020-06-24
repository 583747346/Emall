package com.emall.emalldeskfronton.entity.form;

import com.emall.emallcommon.web.entity.form.BaseForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("购物车插入&更新表单")
public class CarForm extends BaseForm {

    @ApiModelProperty(value = "商品id")
    private String pid;

}
