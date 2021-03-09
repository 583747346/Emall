package com.emall.emallumsentity.entity.vo;

import com.emall.emallumsentity.entity.po.UserPo;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@ApiModel("用户信息视图")
@AllArgsConstructor
@NoArgsConstructor
public class UserVo implements Serializable {
    private Long id;
    @ApiModelProperty(value = "用户姓名")
    private String name;
    @ApiModelProperty(value = "手机号")
    private String mobile;
    @ApiModelProperty(value = "用户名")
    private String username;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "描述")
    private String description;
    @ApiModelProperty(value = "头像")
    private String avatar;
    @ApiModelProperty(value = "是否有效用户")
    private Integer enabled;
    @ApiModelProperty(value = "是否删除")
    private String deleted;
    @ApiModelProperty(value = "角色组")
    private Set<String> roleIds;
    @ApiModelProperty(value = "账号是否未过期")
    private Integer accountNonExpired;
    @ApiModelProperty(value = "密码是否未过期")
    private Integer credentialsNonExpired;
    @ApiModelProperty(value = "是否未锁定")
    private Integer accountNonLocked;
    @ApiModelProperty(value = "创建者")
    private String createdBy;
    @ApiModelProperty(value = "更新者")
    private String updatedBy;
    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdTime;
    @ApiModelProperty(value = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedTime;

    public UserVo(UserPo userPo) {
        BeanUtils.copyProperties(userPo, this);
    }
}
