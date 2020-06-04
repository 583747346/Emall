package com.emall.emallmanageplat.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.emall.emallcommon.web.entity.po.BasePo;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@TableName("brand")
public class BrandPo extends BasePo {
}
