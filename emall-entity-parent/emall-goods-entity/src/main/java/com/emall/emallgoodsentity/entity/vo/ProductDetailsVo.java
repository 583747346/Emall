package com.emall.emallgoodsentity.entity.vo;

import com.emall.emallgoodsentity.entity.form.FullPromotionForm;
import com.emall.emallgoodsentity.entity.form.MemberPriceForm;
import com.emall.emallgoodsentity.entity.form.ProductSkuForm;
import com.emall.emallweb.entity.vo.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@ApiModel("商品详情")
public class ProductDetailsVo extends BaseVo {

    @ApiModelProperty(value = "商品分类")
    private Long productCategoryId;
    @ApiModelProperty(value = "商品分类名")
    private String productCategoryName;
    @ApiModelProperty(value = "商品名")
    private String name;
    @ApiModelProperty(value = "商品标题")
    private String subTitle;
    @ApiModelProperty(value = "品牌id")
    private Long brandId;
    @ApiModelProperty(value = "品牌名")
    private String brandName;
    @ApiModelProperty(value = "商品描述")
    private String description;
    @ApiModelProperty(value = "商品货号")
    private String productNo;
    @ApiModelProperty(value = "商品单价")
    private BigDecimal price;
    @ApiModelProperty(value = "商品市价")
    private BigDecimal marketPrice;
    @ApiModelProperty(value = "商品单位")
    private String unit;
    @ApiModelProperty(value = "商品重量")
    private BigDecimal weight;
    @ApiModelProperty(value = "商品排序")
    private int sort;
    @ApiModelProperty(value = "备注")
    private String note;

    /************************************************************************************
     * 营销部分
     ************************************************************************************/
    @ApiModelProperty(value = "赠送积分")
    private int purchasePoint;
    @ApiModelProperty(value = "购买赠送成长值")
    private int purchaseGrowth;
    @ApiModelProperty(value = "购买积分使用限制")
    private int usePointLimit;
    @ApiModelProperty(value = "商品促销限购数量")
    private int promotionLimit;
    @ApiModelProperty(value = "删除状态(0-未删除，1-删除)")
    private int deleteStatus;
    @ApiModelProperty(value = "发布状态(0-上架，1-下架)")
    private int publishStatus;
    @ApiModelProperty(value = "新品状态(0-老品，1-新品)")
    private int newStatus;
    @ApiModelProperty(value = "推荐状态(0-不推荐，1-推荐)")
    private int recommandStatus;
    @ApiModelProperty(value = "以逗号分割的产品服务：1->无忧退货；2->快速退款；3->免费包邮")
    private String serviceList;
    @ApiModelProperty(value = "详情标题")
    private String detailTitle;
    @ApiModelProperty(value = "详情描述")
    private String detailDesc;
    @ApiModelProperty(value = "详情内容")
    private String detailContent;
    @ApiModelProperty(value = "促销类型")
    private int promotionType;
    /***************促销类型为：限时购*****************/
    //促销类商品
    @ApiModelProperty(value = "促销开始时间")
    private LocalDateTime promotionStartDate;
    @ApiModelProperty(value = "促销结束时间")
    private LocalDateTime promotionEndDate;
    @ApiModelProperty(value = "促销价格")
    private BigDecimal promotionPrice;

    /***************促销类型为：会员价****************/
    @ApiModelProperty(value = "促销-会员价列表")
    private List<MemberPriceForm> memberPriceForms;

    /***************促销类型为：满减价格****************/
    @ApiModelProperty(value = "满减列表")
    private List<FullPromotionForm> fullPromotionForms;

    /*************************************************************************************
     * 商品规格属性
     ************************************************************************************/
    @ApiModelProperty(value = "电脑端详情页")
    private String pcDetailPage;
    @ApiModelProperty(value = "移动端详情页")
    private String mobileDetailPage;
    @ApiModelProperty(value = "画册图片，连产品图片限制为5张，以逗号分割")
    private String albumPics;
    @ApiModelProperty(value = "商品属性")
    private List<ProductSkuForm> productSkus;

    /*************************************************************************************
     * 商品属性参数
     ************************************************************************************/
    private List<ProductParamsVo> prodcutAttributeParams;

}
