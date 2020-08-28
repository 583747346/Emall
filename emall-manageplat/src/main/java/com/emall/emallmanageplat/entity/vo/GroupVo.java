package com.emall.emallmanageplat.entity.vo;

import com.emall.emallweb.entity.vo.BaseVo;
import com.emall.emallweb.entity.po.GroupsPo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Data
@ApiModel("用户组信息视图")
@AllArgsConstructor
@NoArgsConstructor
public class GroupVo extends BaseVo<GroupsPo>{

    @ApiModelProperty(value = "用户组名称")
    private String name;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "创建人")
    private String createdBy;

    @ApiModelProperty(value = "创建日期")
    private Date createdTime;

    public GroupVo(GroupsPo groupsPo){
        BeanUtils.copyProperties(groupsPo,this);
    }
}
