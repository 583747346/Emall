package com.emall.emalldeskfronton.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.emall.emallweb.entity.po.BasePo;
import com.emall.emallweb.entity.po.BaseProcessPo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.math.BigDecimal;

@Data
@ApiModel("购物车实体")
@TableName("emall_car")
public class EmallCarPo extends BasePo {

    @ApiModelProperty(value = "商品id",name = "product_id")
    private Long productId;
    @ApiModelProperty(value = "商品sku-id",name = "sku_id")
    private Long SkuId;
    @ApiModelProperty(value = "会员id",name = "member_id")
    private Long memberId;
    @ApiModelProperty(value = "商品分类id",name = "product_category_id")
    private Integer productCategoryId;
    @ApiModelProperty(value = "购买数量",name = "quantity")
    private Integer quantity;
    @ApiModelProperty(value = "添加到购物车的价格",name = "price")
    private BigDecimal price;
    @ApiModelProperty(value = "商品主图",name = "product_pic")
    private String productPic;
    @ApiModelProperty(value = "商品名称",name = "product_name")
    private String productName;
    @ApiModelProperty(value = "商品副标题",name = "product_sub_title")
    private String productSubTitle;
    @ApiModelProperty(value = "商品sku条码",name = "product_sku_code")
    private String productSkuCode;
    @ApiModelProperty(value = "是否删除,0-不删,1-删除",name = "delete_status")
    private Integer deleteStatus;
    @ApiModelProperty(value = "商品品牌",name = "product_brand")
    private String productBrand;
    @ApiModelProperty(value = "商品货号",name = "product_no")
    private String productNo;
    @ApiModelProperty(value = "商品规格属性",name = "specification")
    private String specification;


}
