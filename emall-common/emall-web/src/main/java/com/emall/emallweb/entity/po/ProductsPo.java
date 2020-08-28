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

@Data
@ApiModel("商品信息")
@AllArgsConstructor
@NoArgsConstructor
@TableName("product")
public class ProductsPo extends BasePo implements Serializable {

    @ApiModelProperty(value = "商品名称", name = "name")
    private String name;
    @ApiModelProperty(value = "品牌id", name = "brand_id")
    private String brandId;
    @ApiModelProperty(value = "商品分类id",name = "product_category_id")
    private String productCategoryId;
    @ApiModelProperty(value = "商品图片", name = "picture")
    private String picture;
    @ApiModelProperty(value = "详情图册", name = "album_pics")
    private String albumPics;
    @ApiModelProperty(value = "商品货号", name = "product_no")
    private String productNo;
    @ApiModelProperty(value = "排序", name = "sort")
    private int sort;
    @ApiModelProperty(value = "单价", name = "price")
    private BigDecimal price;
    @ApiModelProperty(value = "促销价格", name = "promotion_price")
    private BigDecimal promotionPrice;
    @ApiModelProperty(value = "市场价", name = "mkt_price")
    private BigDecimal mktPrice;
    @ApiModelProperty(value = "商品描述", name = "description")
    private String description;
    @ApiModelProperty(value = "商品副标题", name = "sub_title")
    private String subTitle;
    @ApiModelProperty(value = "单位", name = "unit")
    private String unit;
    @ApiModelProperty(value = "重量,默认:克", name = "weight")
    private BigDecimal weight;
    @ApiModelProperty(value = "产品服务(逗号隔开)", name = "service_ids")
    private String serviceIds;
    @ApiModelProperty(value = "详情标题", name = "details_title")
    private String detailsTitle;
    @ApiModelProperty(value = "详情描述", name = "detail_desc")
    private String detailDesc;
    @ApiModelProperty(value = "商品详情内容",name = "detail_content")
    private String detailContent;
    @ApiModelProperty(value = "删除状态：0->未删除；1->已删除", name = "delete_status")
    private String deleteStatus;
    @ApiModelProperty(value = "上架状态：0->下架；1->上架", name = "publish_status")
    private String publishStatus;
    @ApiModelProperty(value = "新品状态:0->不是新品；1->新品", name = "new_status")
    private String newStatus;
    @ApiModelProperty(value = "推荐状态；0->不推荐；1->推荐", name = "recommand_status")
    private String recommandStatus;
    @ApiModelProperty(value = "审核状态：0->未审核；1->审核通过", name = "verify_status")
    private String verifyStatus;
    @ApiModelProperty(value = "备注", name = "note")
    private String note;

}
