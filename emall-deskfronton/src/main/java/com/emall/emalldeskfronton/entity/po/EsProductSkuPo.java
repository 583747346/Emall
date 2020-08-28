package com.emall.emalldeskfronton.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.emall.emallweb.entity.po.BasePo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

import java.math.BigDecimal;

@Data
@ApiModel("商品sku信息")
@AllArgsConstructor
@NoArgsConstructor
@TableName("emall_product_sku")
@Document(indexName = "emall", type = "product_sku", shards = 1, replicas = 0)
public class EsProductSkuPo extends BasePo {

    @ApiModelProperty(value = "商品id", name = "product_id")
    private Long productId;
    @ApiModelProperty(value = "sku编码", name = "sku_code")
    private String skuCode;
    @ApiModelProperty(value = "单价", name = "price")
    private BigDecimal price;
    @ApiModelProperty(value = "库存", name = "stock")
    private int stock;
    @ApiModelProperty(value = "预警库存", name = "low_stock")
    private int lowStock;
    @ApiModelProperty(value = "sku图片", name = "picture")
    private String picture;
    @ApiModelProperty(value = "销售数量", name = "sale")
    private int sale;
    @ApiModelProperty(value = "促销价", name = "promotion_price")
    private BigDecimal promotionPrice;
    @ApiModelProperty(value = "是否锁定库存", name = "lock_stock")
    private int lockStock;
    @ApiModelProperty(value = "商品规格",name="specification")
    private String specification;


}
