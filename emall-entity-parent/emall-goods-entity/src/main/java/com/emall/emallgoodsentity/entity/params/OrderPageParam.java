package com.emall.emallgoodsentity.entity.params;

import com.emall.emallweb.entity.params.BasePageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("订单信息筛选条件-分页")
public class OrderPageParam extends BasePageParam {

    @ApiModelProperty(value = "订单编号")
    private String orderSn;
    @ApiModelProperty(value = "收货人")
    private String receiverName;
    @ApiModelProperty(value = "订单类型")
    private String orderType;
    @ApiModelProperty(value = "订单状态")
    private String orderStatus;
    @ApiModelProperty(value = "订单收货状态")
    private String confirmStatus;
    @ApiModelProperty(value = "下单日期")
    private Date createTime;

}
