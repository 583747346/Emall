package com.emall.emallmanageplat.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.emall.emallweb.entity.po.BasePo;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@TableName("brand")
public class BrandPo extends BasePo {
}
