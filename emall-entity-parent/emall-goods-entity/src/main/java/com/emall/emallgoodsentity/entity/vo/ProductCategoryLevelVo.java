package com.emall.emallgoodsentity.entity.vo;

import com.emall.emallgoodsentity.entity.po.ProductCategoryPo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("商品分类层级")
public class ProductCategoryLevelVo extends ProductCategoryPo {

    @ApiModelProperty("商品分类一级分类的子级")
    private List<ProductCategoryPo> children;

}
