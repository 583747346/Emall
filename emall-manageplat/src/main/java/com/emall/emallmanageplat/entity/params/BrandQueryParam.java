package com.emall.emallmanageplat.entity.params;

import com.emall.emallweb.entity.params.BaseParam;
import com.emall.emallweb.entity.params.BaseQueryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("品牌查询参数-分页")
public class BrandQueryParam extends BaseQueryParam<BrandParam> {

    @ApiModelProperty("品牌名")
    private String name;

}
