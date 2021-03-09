package com.emall.emallumsentity.entity.vo;

import com.emall.emallumsentity.entity.po.RolePo;
import com.emall.emallweb.entity.vo.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@ApiModel("角色信息视图")
@AllArgsConstructor
@NoArgsConstructor
public class RoleVo extends BaseVo<RolePo> {

    @ApiModelProperty(value = "角色code",name = "code")
    private String code;

    @ApiModelProperty(value = "角色名称",name = "name")
    private String name;

    @ApiModelProperty(value = "简介",name = "description")
    private String description;

    public void toVo(RolePo rolePo){
        BeanUtils.copyProperties(rolePo,this);
    }

    public RoleVo(RolePo rolePo){
        BeanUtils.copyProperties(rolePo,this);
    }

}
