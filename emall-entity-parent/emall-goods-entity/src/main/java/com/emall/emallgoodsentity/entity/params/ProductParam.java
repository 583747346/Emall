package com.emall.emallgoodsentity.entity.params;

import com.emall.emallgoodsentity.entity.po.ProductPo;
import com.emall.emallweb.entity.params.BaseParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("产品查询参数")
public class ProductParam extends BaseParam<ProductPo> {

    @ApiModelProperty(value = "产品名")
    private String name;
    @ApiModelProperty(value = "产品类别")
    private Long productCategoryId;
    @ApiModelProperty(value = "品牌id")
    private Long brandId;
    @ApiModelProperty(value = "促销类型,0->没有促销使用原价,1->使用促销价,2->使用会员价,3->使用阶梯价格,4->使用满减价格,5->限时购")
    private Integer promotionType;
    @ApiModelProperty(value = "新品状态，0->新品,1->旧品")
    private Integer newStatus;
    @ApiModelProperty(value = "上线状态，0->上线,1->下线")
    private Integer publishStatus;
    @ApiModelProperty(value = "删除状态，0->未删除,1->删除")
    private Integer deleteStatus;
}
