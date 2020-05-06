package com.emall.emallmanageplat.entity.vo;

import com.emall.emallmanageplat.entity.po.Users;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@ApiModel("用户信息视图")
public class UsersVo implements Serializable {
    private String name;
    private String mobile;
    private String username;
    private String description;
    private String deleted;
    private Set<String> roleIds;
    private String createdBy;
    private String updatedBy;
    private Date createdTime;
    private Date updatedTime;

    public UsersVo(Users users) {
        BeanUtils.copyProperties(users, this);
    }
}
