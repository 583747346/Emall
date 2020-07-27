package com.emall.emallmanageplat.entity.vo;

import com.emall.emallweb.entity.vo.BaseVo;
import com.emall.emallmanageplat.entity.po.BrandPo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@ApiModel("品牌信息视图")
@NoArgsConstructor
public class BrandVo extends BaseVo<BrandPo> {

    @ApiModelProperty(value = "品牌名称")
    private String name;
    @ApiModelProperty(value = "品牌首字母")
    private char firstLetter;
    @ApiModelProperty(value = "品牌排序")
    private int sort;
    @ApiModelProperty(value = "是否为品牌制造商：0->不是；1->是")
    private int factoryStatus;
    @ApiModelProperty(value = "是否显示")
    private int showStatus;
    @ApiModelProperty(value = "产品数量")
    private int productCount;
    @ApiModelProperty(value = "产品评论数量")
    private int productCommentCount;
    @ApiModelProperty(value = "品牌logo")
    private String logo;
    @ApiModelProperty(value = "专区大图")
    private String bigPic;
    @ApiModelProperty(value = "品牌故事")
    private String brandStory;

    public BrandVo(BrandPo brandPo) {
        BeanUtils.copyProperties(brandPo, this);
    }

}
