package com.emall.emallweb.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.emall.emallweb.entity.po.BasePo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@TableName("emall_brand")
public class BrandPo extends BasePo {

    @ApiModelProperty(value = "品牌名称",name = "name")
    private String name;
    @ApiModelProperty(value = "品牌首字母",name = "first_letter")
    private char firstLetter;
    @ApiModelProperty(value = "品牌排序",name = "sort")
    private int sort;
    @ApiModelProperty(value = "是否为品牌制造商：0->不是；1->是",name = "factory_status")
    private int factoryStatus;
    @ApiModelProperty(value = "是否显示",name = "show_status")
    private int showStatus;
    @ApiModelProperty(value = "产品数量",name = "product_count")
    private int productCount;
    @ApiModelProperty(value = "产品评论数量",name = "product_comment_count")
    private int productCommentCount;
    @ApiModelProperty(value = "品牌logo",name = "logo")
    private String logo;
    @ApiModelProperty(value = "专区大图",name = "big_pic")
    private String bigPic;
    @ApiModelProperty(value = "品牌故事",name = "brand_story")
    private String brandStory;

}
