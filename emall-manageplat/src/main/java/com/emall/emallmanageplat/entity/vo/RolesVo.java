package com.emall.emallmanageplat.entity.vo;

import com.emall.emallweb.entity.vo.BaseVo;
import com.emall.emallweb.entity.po.RolesPo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
@ApiModel("角色信息视图")
public class RolesVo extends BaseVo<RolesPo> {

    @ApiModelProperty(value = "角色code",name = "code")
    private String code;

    @ApiModelProperty(value = "角色名称",name = "name")
    private String name;

    @ApiModelProperty(value = "简介",name = "description")
    private String description;

    public void toVo(RolesPo rolesPo){
        BeanUtils.copyProperties(rolesPo,this);
    }

    public RolesVo(RolesPo rolesPo){
        BeanUtils.copyProperties(rolesPo,this);
    }

}
