package com.emall.emallumsentity.entity.vo;

import com.emall.emallumsentity.entity.po.GroupPo;
import com.emall.emallweb.entity.vo.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Data
@ApiModel("用户组信息视图")
@AllArgsConstructor
@NoArgsConstructor
public class GroupVo extends BaseVo<GroupPo>{

    @ApiModelProperty(value = "用户组名称")
    private String name;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "创建人")
    private String createdBy;

    @ApiModelProperty(value = "创建日期")
    private LocalDateTime createdTime;

    public GroupVo(GroupPo groupsPo){
        BeanUtils.copyProperties(groupsPo,this);
    }
}
