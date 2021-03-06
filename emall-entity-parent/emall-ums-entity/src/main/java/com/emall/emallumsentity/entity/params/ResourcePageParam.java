package com.emall.emallumsentity.entity.params;

import com.emall.emallweb.entity.params.BasePageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("查询资源参数-分页")
public class ResourcePageParam extends BasePageParam<ResourceParam> implements Serializable {

    @ApiModelProperty(value = "资源名称")
    private String name;
    @ApiModelProperty(value = "资源类型")
    private String type;
    @ApiModelProperty(value = "资源方法")
    private String method;
}
