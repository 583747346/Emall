package com.emall.emallgoodsentity.entity.params;

import com.emall.emallweb.entity.params.BaseParam;
import com.emall.emallweb.entity.po.BrandPo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("品牌查询参数")
public class BrandParam extends BaseParam<BrandPo> {

    @ApiModelProperty("品牌名")
    private String name;

}
