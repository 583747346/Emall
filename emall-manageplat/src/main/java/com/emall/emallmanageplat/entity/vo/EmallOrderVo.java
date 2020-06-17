package com.emall.emallmanageplat.entity.vo;

import com.emall.emallcommon.web.entity.vo.BaseVo;
import com.emall.emallmanageplat.entity.po.EmallOrderPo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
@ApiModel(value = "订单信息视图")
public class EmallOrderVo extends BaseVo {


    public EmallOrderVo(EmallOrderPo emallOrderPo) {
        BeanUtils.copyProperties(emallOrderPo, this);
    }

}
