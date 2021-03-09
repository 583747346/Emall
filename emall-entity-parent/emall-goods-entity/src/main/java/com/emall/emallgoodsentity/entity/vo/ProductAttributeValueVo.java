package com.emall.emallgoodsentity.entity.vo;

import com.emall.emallweb.entity.vo.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("商品属性列表视图")
public class ProductAttributeValueVo extends BaseVo {

    @ApiModelProperty(value = "属性名",name = "name")
    private String name;

    @ApiModelProperty(value = "规格数量(每个属性键值都有多个规格值)")
    private Integer specsNum;

    @ApiModelProperty(value = "参数值")
    private Integer paramNum;

}
