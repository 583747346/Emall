package com.emall.emallumsentity.entity.params;

import com.emall.emallumsentity.entity.po.GroupPo;
import com.emall.emallweb.entity.params.BaseParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("用户组查询参数")
public class GroupParam extends BaseParam<GroupPo> {

    @ApiModelProperty(value = "用户组名")
    private String name;

}
