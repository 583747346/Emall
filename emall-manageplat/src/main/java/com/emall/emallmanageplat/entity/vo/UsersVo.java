package com.emall.emallmanageplat.entity.vo;

import com.emall.emallmanageplat.entity.po.UsersPo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@ApiModel("用户信息视图")
public class UsersVo implements Serializable {
    private Long id;
    private String name;
    private String mobile;
    private String username;
    private String password;
    private String description;
    @ApiModelProperty(value = "是否有效用户")
    private Integer enabled;
    private String deleted;
    private Set<String> roleIds;
    @ApiModelProperty(value = "账号是否未过期")
    private Integer accountNonExpired;
    @ApiModelProperty(value = "密码是否未过期")
    private Integer credentialsNonExpired;
    @ApiModelProperty(value = "是否未锁定")
    private Integer accountNonLocked;
    private String createdBy;
    private String updatedBy;
    private Date createdTime;
    private Date updatedTime;

    public UsersVo(UsersPo usersPo) {
        BeanUtils.copyProperties(usersPo, this);
    }
}
