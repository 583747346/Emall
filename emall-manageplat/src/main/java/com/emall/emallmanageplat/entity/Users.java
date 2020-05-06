package com.emall.emallmanageplat.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
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
public class Users{

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码密文
     */
    private String password;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 用户手机
     */
    private String mobile;

    /**
     * 简介
     */
    private String description;

    /**
     * 是否已删除Y：已删除，N：未删除
     */
    private String deleted;

    /**
     * 是否有效用户
     */
    private Integer enabled;

    /**
     * 账号是否未过期
     */
    @TableField("account_non_expired")
    private Integer accountNonExpired;

    /**
     * 密码是否未过期
     */
    @TableField("credentials_non_expired")
    private Integer credentialsNonExpired;

    /**
     * 是否未锁定
     */
    @TableField("account_non_locked")
    private Integer accountNonLocked;

    /**
     * 创建时间
     */
    @TableField("created_time")
    private Date createdTime;

    /**
     * 更新时间
     */
    @TableField("updated_time")
    private Date updatedTime;

    /**
     * 创建人
     */
    @TableField("created_by")
    private String createdBy;

    /**
     * 更新人
     */
    @TableField("updated_by")
    private String updatedBy;

}
