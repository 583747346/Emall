package com.emall.emallmanageplat.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.emall.emallcommon.web.entity.po.BasePo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("商品属性分类")
@TableName("emall_product_attribute_category")
public class ProductAttributeCategoryPo extends BasePo {

    @ApiModelProperty(value = "商品属性分类描述",name = "name")
    private String name;

}
