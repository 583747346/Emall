package com.emall.emallmanageplat.entity.po;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import com.emall.emallweb.entity.po.BasePo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author qinlang
 * @since 2020-05-06
 */
@Data
@Accessors(chain = true)
@TableName("users")
public class UsersPo extends BasePo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名",name = "username")
    private String username;

    /**
     * 用户密码密文
     */
    @ApiModelProperty(value = "用户密码密文",name = "password")
    private String password;

    /**
     * 用户姓名
     */
    @ApiModelProperty(value = "用户姓名",name = "name")
    private String name;

    /**
     * 用户手机
     */
    @ApiModelProperty(value = "用户手机",name = "mobile")
    private String mobile;

    /**
     * 简介
     */
    @ApiModelProperty(value = "简介",name = "description")
    private String description;

    /**
     * 是否已删除Y：已删除，N：未删除
     */
    @ApiModelProperty(value = "删除标记（0，1-删除）",name = "deleted")
    private String deleted;

    /**
     * 是否有效用户
     */
    @ApiModelProperty(value = "是否有效用户",name = "enabled")
    private Integer enabled;

    /**
     * 账号是否未过期
     */
    @ApiModelProperty(value = "账号是否未过期",name = "account_non_expired")
    private Integer accountNonExpired;

    /**
     * 密码是否未过期
     */
    @ApiModelProperty(value = "密码是否未过期",name = "credentials_non_expired")
    private Integer credentialsNonExpired;

    /**
     * 是否未锁定
     */
    @ApiModelProperty(value = "是否未锁定",name = "account_non_locked")
    private Integer accountNonLocked;

}
