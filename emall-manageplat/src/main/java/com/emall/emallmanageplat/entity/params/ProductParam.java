package com.emall.emallmanageplat.entity.params;

import com.emall.emallweb.entity.params.BaseParam;
import com.emall.emallmanageplat.entity.po.ProductsPo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("产品查询参数")
public class ProductParam extends BaseParam<ProductsPo> {

    @ApiModelProperty(value = "产品名")
    private String name;
    @ApiModelProperty(value = "产品类别")
    private String productCategory;
    @ApiModelProperty(value = "品牌")
    private String brand;

}
