package com.emall.emallmanageplat.entity.form;

import com.emall.emallweb.entity.form.BaseForm;
import com.emall.emallmanageplat.entity.po.ProductSkuPo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@ApiModel("商品sku库存更新表单")
public class ProductSkuForm extends BaseForm<ProductSkuPo> {

    @ApiModelProperty(value = "sku-id")
    @NotNull
    private String skuid;

    @ApiModelProperty(value = "库存")
    @NotNull
    @Min(0)
    private int stock;

}
