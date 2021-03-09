package com.emall.emallgoodsentity.entity.form;

import com.emall.emallgoodsentity.entity.po.MemberPricePo;
import com.emall.emallweb.entity.form.BaseForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel("会员价格表单")
public class MemberPriceForm extends BaseForm<MemberPricePo> {

    @ApiModelProperty(value = "商品id")
    private Long productId;

    @ApiModelProperty(value = "会员价id")
    private Long rankId;

    @ApiModelProperty(value = "会员价格")
    private BigDecimal memberPrice;

    @ApiModelProperty(value = "会员等级描述")
    private String memberLevelName;

}
