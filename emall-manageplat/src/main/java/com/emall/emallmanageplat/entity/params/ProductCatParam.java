package com.emall.emallmanageplat.entity.params;

import com.emall.emallcommon.web.entity.params.BaseParam;
import com.emall.emallmanageplat.entity.po.ProductCategoryPo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("商品分类筛选参数")
public class ProductCatParam extends BaseParam<ProductCategoryPo> {

    @ApiModelProperty(value = "商品分类名")
    private String name;

}
