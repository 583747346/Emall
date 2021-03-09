package com.emall.emallumsentity.entity.vo;

import com.emall.emallumsentity.entity.po.ResourcePo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Data
@ApiModel("资源树")
@AllArgsConstructor
@NoArgsConstructor
public class ResourceTreeVo {

    @ApiModelProperty("资源id")
    private Long id;

    @ApiModelProperty("资源类型")
    private String type;

    @ApiModelProperty("资源名")
    private String name;

    @ApiModelProperty("资源描述")
    private String description;

    @ApiModelProperty("资源子集")
    List<ResourceTreeVo> children;

    public ResourceTreeVo(ResourcePo resourcePo) {
        BeanUtils.copyProperties(resourcePo, this);
    }
}
