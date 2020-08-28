package com.emall.emallmanageplat.entity.form;

import com.emall.emallweb.entity.po.ProductsPo;
import com.emall.emallweb.entity.form.BaseForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@ApiModel("产品插入&更新表单")
public class ProductForm extends BaseForm<ProductsPo> {

    @ApiModelProperty(value = "商品名")
    @NotNull
    private String name;
    @ApiModelProperty(value = "商品图片")
    private String picture;
    @ApiModelProperty(value = "商品货号")
    @NotNull
    private String productSn;
    @ApiModelProperty(value = "商品排序")
    private int sort;
    @ApiModelProperty(value = "商品单价")
    @Min(value = 0)
    private BigDecimal price;
    @ApiModelProperty(value = "商品促销价")
    private BigDecimal promotionPrice;
    @ApiModelProperty(value = "商品描述")
    private String description;
    @ApiModelProperty(value = "商品原价")
    private BigDecimal originalPrice;
    @ApiModelProperty(value = "商品标题")
    private String subTitle;
    @ApiModelProperty(value = "商品单位")
    private String unit;
    @ApiModelProperty(value = "商品重量")
    private BigDecimal weight;
    @ApiModelProperty(value = "以逗号分割的产品服务：1->无忧退货；2->快速退款；3->免费包邮")
    private String serviceIds;
    @ApiModelProperty(value = "画册图片，连产品图片限制为5张，以逗号分割")
    private String albumPics;
    @ApiModelProperty(value = "详情标题")
    private String detailTitle;
    @ApiModelProperty(value = "详情描述")
    private String detailDesc;
    @ApiModelProperty(value = "详情内容")
    private MultipartFile detailContent;
    @ApiModelProperty(value = "删除状态(0-未删除，1-删除)")
    private int deleteStatus;
    @ApiModelProperty(value = "发布状态(0-上架，1-下架)")
    private int publishStatus;
    @ApiModelProperty(value = "新品状态(0-老品，1-新品)")
    private int newStatus;
    @ApiModelProperty(value = "推荐状态(0-不推荐，1-推荐)")
    private int recommandStatus;
    @ApiModelProperty(value = "赠送积分")
    private int purchasePoint;
    @ApiModelProperty(value = "购买赠送成长值")
    private int purchaseGrowth;
    @ApiModelProperty(value = "促销限购数量")
    private int promotionLimit;
    @ApiModelProperty(value = "促销开始时间")
    private LocalDateTime promotionStartdate;
    @ApiModelProperty(value = "促销结束时间")
    private LocalDateTime promotionEntdate;
    @ApiModelProperty(value = "备注")
    private String note;

    /*************************************************************************************
     * 品牌
     ************************************************************************************/
    @ApiModelProperty(value = "品牌")
    private String brandId;

    /*************************************************************************************
     * 商品分类
     ************************************************************************************/
    @ApiModelProperty(value = "商品分类")
    private String productCategoryId;

    /*************************************************************************************
     * 商品规格属性
     ************************************************************************************/
    @ApiModelProperty(value = "商品属性")
    private List<ProductSkuForm> productSkus;


}
