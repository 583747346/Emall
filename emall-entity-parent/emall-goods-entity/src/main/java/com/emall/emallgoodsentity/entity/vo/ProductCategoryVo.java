package com.emall.emallgoodsentity.entity.vo;

import com.emall.emallgoodsentity.entity.po.ProductCategoryPo;
import com.emall.emallweb.entity.vo.BaseVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategoryVo extends BaseVo<ProductCategoryPo> {

    @ApiModelProperty(value = "商品分类描述")
    private String name;
    @ApiModelProperty(value = "商品分类层级")
    private int level;
    @ApiModelProperty(value = "是否显示在导航栏：0->不显示；1->显示")
    private int navStatus;
    @ApiModelProperty(value = "商品分类排序")
    private int sort;
    @ApiModelProperty(value = "商品分类图标")
    private String icon;
    @ApiModelProperty(value = "商品分类描述")
    private String description;

    /**
     * PO -> VO
     * @param po
     */
    public ProductCategoryVo(ProductCategoryPo po){
        BeanUtils.copyProperties(po,this);
    }

}
