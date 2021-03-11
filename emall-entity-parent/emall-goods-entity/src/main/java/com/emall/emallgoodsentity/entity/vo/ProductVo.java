package com.emall.emallgoodsentity.entity.vo;

import com.emall.emallgoodsentity.entity.po.ProductPo;
import com.emall.emallweb.entity.vo.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

@Data
@ApiModel("产品信息视图")
@NoArgsConstructor
public class ProductVo extends BaseVo<ProductPo> {

    @ApiModelProperty(value = "商品主图")
    private String albumPics;
    @ApiModelProperty(value = "品牌名称")
    private String brandName;
    @ApiModelProperty(value = "分类")
    private String productCategoryName;
    @ApiModelProperty(value = "商品名称")
    private String name;
    @ApiModelProperty(value = "商品货号")
    private String productNo;
    @ApiModelProperty(value = "单价", name = "price")
    private BigDecimal price;
    @ApiModelProperty(value = "市场价", name = "market_price")
    private BigDecimal marketPrice;
    @ApiModelProperty(value = "上架状态：0->上架；1->下架", name = "publish_status")
    private int publishStatus;
    @ApiModelProperty(value = "新品状态:0->新品；1->老品", name = "new_status")
    private int newStatus;
    @ApiModelProperty(value = "推荐状态；0->推荐；1->不推荐", name = "recommand_status")
    private int recommandStatus;
    @ApiModelProperty(value = "审核状态：0->审核通过；1->未审核", name = "verify_status")
    private int verifyStatus;
    @ApiModelProperty(value = "活动状态：0->活动；1->非活动", name = "delete_status")
    private int deleteStatus;

    public ProductVo(ProductPo productPo){
        BeanUtils.copyProperties(productPo,this);
    }

}
