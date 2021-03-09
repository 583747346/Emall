package com.emall.emallgoodsentity.entity.params;

import com.emall.emallweb.entity.params.BasePageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("产品关键字查询参数-分页")
public class ProductPageParam extends BasePageParam<ProductParam> {

    @ApiModelProperty(value = "产品名")
    private String name;
    @ApiModelProperty(value = "产品类别")
    private String productCategory;
    @ApiModelProperty(value = "品牌")
    private String brand;
    @ApiModelProperty(value = "促销类型,0->没有促销使用原价,1->使用促销价,2->使用会员价,4->使用满减价格")
    private Integer promotionType;
    @ApiModelProperty(value = "新品状态，0->新品,1->旧品")
    private Integer newStatus;
    @ApiModelProperty(value = "上线状态，0->上线,1->下线")
    private Integer publishStatus;
}
