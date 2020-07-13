package com.emall.emallmanageplat.entity.params;

import com.emall.emallweb.entity.params.BaseParam;
import com.emall.emallmanageplat.entity.po.ProductSkuPo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("商品sku查询参数")
public class ProductSkuParam extends BaseParam<ProductSkuPo> {

    @ApiModelProperty(value = "商品id")
    private String productId;

}
