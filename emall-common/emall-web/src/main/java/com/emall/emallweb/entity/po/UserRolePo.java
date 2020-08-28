package com.emall.emallweb.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.emall.emallweb.entity.po.BasePo;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.io.Serializable;

@Data
@Accessors(chain = true)
@TableName("user_role_relation")
public class UserRolePo extends BasePo implements Serializable {

    @ApiModelProperty(value = "用户id",name = "user_id")
    private Long userId;

    @ApiModelProperty(value = "角色id",name = "role_id")
    private Long roleId;

}
