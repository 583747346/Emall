package com.emall.gatewayadmin.entity.form;

import com.emall.emallweb.entity.form.BaseQueryForm;
import com.emall.gatewayadmin.entity.params.GatewayRouteQueryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Past;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@ApiModel
@Data
public class GatewayRouteQueryForm extends BaseQueryForm<GatewayRouteQueryParam> {

    @ApiModelProperty(value = "uri路径",name = "uri")
    private String uri;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Past(message = "查询开始时间必须小于当前日期")
    @ApiModelProperty(value = "查询开始时间")
    private Date createdTimeStart;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Past(message = "查询结束时间必须小于当前日期")
    @ApiModelProperty(value = "查询结束时间")
    private Date createdTimeEnd;

    @ApiModelProperty(value = "网关描述", name = "description")
    private String description;

}
