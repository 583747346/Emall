package com.emall.gatewayadmin.entity.po;


import com.baomidou.mybatisplus.annotation.TableName;
import com.emall.emallweb.entity.po.BasePo;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "网关表")
@TableName("gateway_route")  //这里类名使用驼峰规则命名，可以不用写@TableName
public class GatewayRoutePo extends BasePo {

    private String routeId;
    private String uri;
    private String predicates;
    private String filters;
    private Integer orders = 0;
    private String description;
    private String status = "Y";

}
