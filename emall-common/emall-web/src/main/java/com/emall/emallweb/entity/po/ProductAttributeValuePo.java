package com.emall.emallweb.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.emall.emallweb.entity.po.BasePo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("emall_product_attribute_value")
@ApiModel("商品属性值")
public class ProductAttributeValuePo extends BasePo {

    @ApiModelProperty(value = "商品属性id",name = "product_attribute_id")
    private String productAttributeId;
    @ApiModelProperty(value = "属性值",name = "value")
    private String value;

}
