package com.emall.emallmanageplat.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.emall.emallcommon.web.entity.po.BasePo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("商品分类")
@TableName("emall_product_category")
public class ProductCategoryPo extends BasePo {

    @ApiModelProperty(value = "父id", name = "parent_id")
    private String parentId;
    @ApiModelProperty(value = "商品分类描述", name = "name")
    private String name;
    @ApiModelProperty(value = "层级", name = "level")
    private int level;
    @ApiModelProperty(value = "是否显示在导航栏：0->不显示；1->显示", name = "nav_status")
    private int navStatus;
    @ApiModelProperty(value = "排序", name = "nav_status")
    private int sort;
    @ApiModelProperty(value = "图标", name = "icon")
    private String icon;
    @ApiModelProperty(value = "描述", name = "description")
    private String description;

}
