package com.emall.emallgoodsentity.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("sku规格")
public class SkuSpecificationVo {

    @ApiModelProperty("规格描述")
    private String key;
    @ApiModelProperty("规格值")
    private String value;
}
