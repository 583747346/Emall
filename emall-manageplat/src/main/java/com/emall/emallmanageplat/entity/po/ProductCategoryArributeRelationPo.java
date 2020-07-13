package com.emall.emallmanageplat.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.emall.emallweb.entity.po.BasePo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("商品属性分类-属性值关系")
@TableName("emall_product_attribute_relation")
public class ProductCategoryArributeRelationPo extends BasePo {

    @ApiModelProperty(value = "商品分类id",name = "product_category_id")
    private String productCategoryId;
    @ApiModelProperty(value = "商品属性id",name = "product_attribute_id")
    private String productAttributeId;

}
