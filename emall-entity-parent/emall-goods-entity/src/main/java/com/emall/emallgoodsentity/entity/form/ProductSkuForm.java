package com.emall.emallgoodsentity.entity.form;

import com.emall.emallgoodsentity.entity.vo.SkuSpecificationVo;
import com.emall.emallweb.entity.form.BaseForm;
import com.emall.emallgoodsentity.entity.po.ProductSkuPo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Data
@ApiModel("商品sku库存更新表单")
public class ProductSkuForm extends BaseForm<ProductSkuPo> {

    @ApiModelProperty(value = "sku_code")
    private String skuCode;

    @ApiModelProperty(value = "库存")
    @NotNull
    @Min(0)
    private int stock;

    @ApiModelProperty(value = "单价", name = "price")
    private BigDecimal price;

    @ApiModelProperty(value = "预警库存", name = "low_stock")
    @Min(0)
    private int lowStock;

    @ApiModelProperty(value = "sku图片", name = "picture")
    private String[] picture;

/*    @ApiModelProperty(value = "促销价", name = "promotion_price")
    private BigDecimal promotionPrice;*/

    @ApiModelProperty(value = "商品规格",name="specification")
    private List<SkuSpecificationVo> specification;

}
