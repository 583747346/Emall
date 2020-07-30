package com.emall.emallmanageplat.entity.form;

import com.emall.emallweb.entity.form.BaseForm;
import com.emall.emallmanageplat.entity.po.BrandPo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Min;

@Data
@ApiModel("品牌添加/更新表单")
public class BrandForm extends BaseForm<BrandPo> {

    @ApiModelProperty(value = "品牌名称",required = true)
    private String name;
    @ApiModelProperty(value = "品牌首字母")
    private char firstLetter;
    @ApiModelProperty(value = "品牌排序")
    private int sort;
    @ApiModelProperty(value = "是否为品牌制造商：0->是；1->不是",required = true)
    private int factoryStatus;
    @ApiModelProperty(value = "是否显示0->显示，1->不显示")
    private int showStatus;
    @ApiModelProperty(value = "产品数量")
    private int productCount;
    @ApiModelProperty(value = "产品评论数量")
    private int productCommentCount;
    @ApiModelProperty(value = "品牌logo")
    private MultipartFile logo;
    @ApiModelProperty(value = "专区大图")
    private MultipartFile bigPic;
    @ApiModelProperty(value = "品牌故事")
    private String brandStory;


}
