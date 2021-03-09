package com.emall.emallgoodsentity.entity.vo;

import com.emall.emallgoodsentity.entity.po.ProductAttributePo;
import com.emall.emallweb.entity.vo.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@ApiModel("商品规格视图")
@AllArgsConstructor
@NoArgsConstructor
public class ProductAttributeVo extends BaseVo<ProductAttributePo> {

    @ApiModelProperty(value = "属性名")
    private String name;
    @ApiModelProperty("属性列表(规格|参数)")
    private String attributeList;
    @ApiModelProperty(value = "属性状态(0-禁用,1-启用)")
    private Integer status;

    public ProductAttributeVo(ProductAttributePo po) {
        BeanUtils.copyProperties(po, this);
    }
}
