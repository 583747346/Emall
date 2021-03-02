package com.emall.emallweb.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.emall.emallweb.entity.po.BasePo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@ApiModel("商品信息")
@AllArgsConstructor
@NoArgsConstructor
@TableName("emall_product")
public class ProductPo extends BasePo implements Serializable {

    @ApiModelProperty(value = "商品名称", name = "name")
    private String name;
    @ApiModelProperty(value = "品牌id", name = "brand_id")
    private Long brandId;
    @ApiModelProperty(value = "商品分类id", name = "product_category_id")
    private Long productCategoryId;
    //    @ApiModelProperty(value = "商品图片", name = "picture")
//    private String picture;
    @ApiModelProperty(value = "详情图册", name = "album_pics")
    private String albumPics;
    @ApiModelProperty(value = "商品货号", name = "product_no")
    private String productNo;
    @ApiModelProperty(value = "排序", name = "sort")
    private int sort;
    @ApiModelProperty(value = "单价", name = "price")
    private BigDecimal price;
    @ApiModelProperty(value = "市场价", name = "market_price")
    private BigDecimal marketPrice;
    @ApiModelProperty(value = "商品描述", name = "description")
    private String description;
    @ApiModelProperty(value = "商品副标题", name = "sub_title")
    private String subTitle;
    @ApiModelProperty(value = "单位", name = "unit")
    private String unit;
    @ApiModelProperty(value = "重量,默认:克", name = "weight")
    private BigDecimal weight;
    @ApiModelProperty(value = "产品服务(逗号隔开)", name = "service_list")
    private String serviceList;
    @ApiModelProperty(value = "详情标题", name = "detail_title")
    private String detailTitle;
    @ApiModelProperty(value = "详情描述", name = "detail_desc")
    private String detailDesc;
    @ApiModelProperty(value = "商品详情内容", name = "detail_content")
    private String detailContent;
    @ApiModelProperty(value = "删除状态：0->未删除；1->已删除", name = "delete_status")
    private int deleteStatus;
    @ApiModelProperty(value = "上架状态：0->下架；1->上架", name = "publish_status")
    private int publishStatus;
    @ApiModelProperty(value = "新品状态:0->不是新品；1->新品", name = "new_status")
    private int newStatus;
    @ApiModelProperty(value = "推荐状态；0->不推荐；1->推荐", name = "recommand_status")
    private int recommandStatus;
    @ApiModelProperty(value = "审核状态：0->未审核；1->审核通过", name = "verify_status")
    private int verifyStatus;
    @ApiModelProperty(value = "电脑端详情页", name = "pc_detail_page")
    private String pcDetailPage;
    @ApiModelProperty(value = "移动端端详情页", name = "mobile_detail_page")
    private String mobileDetailPage;
    @ApiModelProperty(value = "购买赠送积分值", name = "purchase_point")
    private int purchasePoint;
    @ApiModelProperty(value = "购买赠送成长值", name = "purchase_growth")
    private int purchaseGrowth;
    @ApiModelProperty(value = "使用积分限制", name = "use_point_limit")
    private int use_pointLimit;
    @ApiModelProperty(value = "促销限购数量", name = "promotion_limit")
    private int promotionLimit;
    @ApiModelProperty(value = "备注", name = "note")
    private String note;

    //促销模块
    @ApiModelProperty(value = "促销类型",name = "promotion_type")
    private int promotionType;

    /***************促销类型为：限时购*****************/
    @ApiModelProperty(value = "促销价格", name = "promotion_price")
    private BigDecimal promotionPrice;
    @ApiModelProperty(value = "促销开始时间", name = "promotion_start_date")
    private LocalDateTime promotionStartDate;
    @ApiModelProperty(value = "促销结束时间", name = "promotion_end_date")
    private LocalDateTime promotionEndDate;

}
