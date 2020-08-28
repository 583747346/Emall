package com.emall.emallweb.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.emall.emallweb.entity.po.BasePo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("商品分类")
@TableName("emall_product_category")
public class ProductCategoryPo extends BasePo {

    @ApiModelProperty(value = "父id", name = "parent_id")
    private Long parentId;
    @ApiModelProperty(value = "商品分类描述", name = "name")
    private String name;
    @ApiModelProperty(value = "层级", name = "level")
    private Integer level;
    @ApiModelProperty(value = "是否显示在导航栏：0->不显示；1->显示", name = "nav_status")
    private Integer navStatus;
    @ApiModelProperty(value = "排序", name = "nav_status")
    private Integer sort;
    @ApiModelProperty(value = "图标", name = "icon")
    private String icon;
    @ApiModelProperty(value = "描述", name = "description")
    private String description;

}
