package com.emall.emallmanageplat.entity.vo;

import com.emall.emallweb.entity.vo.BaseVo;
import com.emall.emallweb.entity.po.ResourcePo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

@Data
@ApiModel("资源信息视图")
@NoArgsConstructor
public class ResourceVo extends BaseVo<ResourcePo> implements Serializable {

    @ApiModelProperty(value = "资源名称")
    private String name;
    @ApiModelProperty(value = "资源code")
    private String code;
    @ApiModelProperty(value = "资源类型")
    private String type;
    @ApiModelProperty(value = "资源url")
    private String url;
    @ApiModelProperty(value = "资源方法")
    private String method;
    @ApiModelProperty(value = "资源描述")
    private String description;

    public ResourceVo(ResourcePo resourcePo){
        BeanUtils.copyProperties(resourcePo,this);
    }
}
