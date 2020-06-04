package com.emall.emallmanageplat.entity.params;

import com.emall.emallcommon.web.entity.params.BaseParam;
import com.emall.emallmanageplat.entity.po.BrandPo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.bytebuddy.description.NamedElement;

@Data
@ApiModel("品牌查询参数")
public class BrandParam extends BaseParam<BrandPo> {

    @ApiModelProperty("品牌名")
    private String name;

}
