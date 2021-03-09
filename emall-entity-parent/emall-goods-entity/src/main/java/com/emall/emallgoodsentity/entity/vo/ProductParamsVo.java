package com.emall.emallgoodsentity.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("商品添加-属性参数")
public class ProductParamsVo {

    @ApiModelProperty("商品属性id")
    private Long paramId;
    @ApiModelProperty("商品属性参数值")
    private String[] paramValue;

}
