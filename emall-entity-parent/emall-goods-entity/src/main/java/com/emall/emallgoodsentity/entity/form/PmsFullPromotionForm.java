package com.emall.emallgoodsentity.entity.form;

import com.emall.emallgoodsentity.entity.po.FullPromotionPo;
import com.emall.emallweb.entity.form.BaseForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel("促销--满减价格")
public class PmsFullPromotionForm extends BaseForm<FullPromotionPo>{

    @ApiModelProperty("满价")
    private BigDecimal fullPrice;
    @ApiModelProperty("减价")
    private BigDecimal reducePrice;

}
