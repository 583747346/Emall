package com.emall.emallgoodsentity.entity.form;

import com.emall.emallgoodsentity.entity.po.ProductCategoryPo;
import com.emall.emallweb.entity.form.BaseForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("商品分类插入&更新表单")
public class ProductCatForm extends BaseForm<ProductCategoryPo> {

    @ApiModelProperty(value = "父id")
    private Long parentId;
    @ApiModelProperty(value = "商品分类名")
    private String name;
    @ApiModelProperty(value = "商品分类层级")
    private int level;
    @ApiModelProperty(value = "商品分类状态")
    private int navStatus;
    @ApiModelProperty(value = "商品分类排序")
    private int sort;
    @ApiModelProperty(value = "商品分类图标")
    private String icon;
    @ApiModelProperty(value = "商品分类描述")
    private String description;

}
