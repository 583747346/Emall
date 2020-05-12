package com.emall.emallmanageplat.entity.po;

import com.emall.emallcommon.web.entity.BasePo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;

@Data
@Accessors(chain = true)
public class UserRoleRelation extends BasePo implements Serializable {

    @ApiModelProperty(value = "用户id",name = "user_id")
    private String userId;

    @ApiModelProperty(value = "角色id",name = "role_id")
    private String roleId;

}
