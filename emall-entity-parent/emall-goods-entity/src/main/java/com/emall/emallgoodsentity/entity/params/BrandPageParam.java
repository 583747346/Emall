package com.emall.emallgoodsentity.entity.params;

import com.emall.emallweb.entity.params.BasePageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("品牌查询参数-分页")
public class BrandPageParam extends BasePageParam<BrandParam> {

    @ApiModelProperty("品牌名")
    private String name;

}
