package com.emall.emallmanageplat.entity.params;

import com.emall.emallweb.entity.params.BaseParam;
import com.emall.emallmanageplat.entity.po.ResourcePo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("资源查询参数列表")
public class ResourceParam extends BaseParam<ResourcePo> {

    @ApiModelProperty(value = "资源名称")
    private String name;
    @ApiModelProperty(value = "资源类型")
    private String type;
    @ApiModelProperty(value = "资源方法")
    private String method;

}
