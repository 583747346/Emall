package com.emall.emallmanageplat.entity.form;

import com.emall.emallweb.entity.form.BaseForm;
import com.emall.emallmanageplat.entity.po.ProductCategoryPo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("商品分类插入&更新表单")
public class ProductCatForm extends BaseForm<ProductCategoryPo> {

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
    @ApiModelProperty(value = "商品子级分类")
    private List<String> catIds;

}
