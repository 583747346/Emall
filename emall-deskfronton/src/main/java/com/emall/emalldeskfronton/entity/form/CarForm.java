package com.emall.emalldeskfronton.entity.form;

import com.emall.emallweb.entity.form.BaseForm;
import com.emall.emalldeskfronton.entity.po.EmallCarPo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

@Data
@ApiModel("购物车插入&更新表单")
public class CarForm extends BaseForm {

    @ApiModelProperty(value = "商品id",required = true)
    private String pid;
/*    @ApiModelProperty(value = "会员id",required = true)
    private String uid;*/
    @ApiModelProperty(value = "商品sku-id")
    private String SkuId;
    @ApiModelProperty(value = "商品分类id")
    private Integer productCategoryId;
    @ApiModelProperty(value = "购买数量")
    private Integer quantity;
    @ApiModelProperty(value = "添加到购物车的价格")
    private BigDecimal price;
    @ApiModelProperty(value = "商品主图")
    private String productPic;
    @ApiModelProperty(value = "商品名称")
    private String productName;
    @ApiModelProperty(value = "商品副标题")
    private String productSubTitle;
    @ApiModelProperty(value = "商品sku条码")
    private String productSkuCode;
    @ApiModelProperty(value = "是否删除")
    private Integer deleteStatus;
    @ApiModelProperty(value = "商品品牌")
    private String productBrand;
    @ApiModelProperty(value = "商品货号")
    private String productNo;
    @ApiModelProperty(value = "商品规格属性")
    private String specification;

    public EmallCarPo toPo() {
        EmallCarPo emallCarPo = new EmallCarPo();
        BeanUtils.copyProperties(this, emallCarPo);
        return emallCarPo;
    }
}
