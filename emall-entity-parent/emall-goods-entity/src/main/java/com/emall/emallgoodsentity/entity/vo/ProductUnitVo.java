package com.emall.emallgoodsentity.entity.vo;

import com.emall.emallgoodsentity.entity.po.ProductUnitPo;
import com.emall.emallweb.entity.vo.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@ApiModel("商品单位视图")
@AllArgsConstructor
@NoArgsConstructor
public class ProductUnitVo extends BaseVo {

    @ApiModelProperty(value = "单位")
    private String unit;

    @ApiModelProperty(value = "状态")
    private Integer status;

    public ProductUnitVo(ProductUnitPo productUnitVo) {
        BeanUtils.copyProperties(productUnitVo, this);
    }

}
