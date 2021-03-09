package com.emall.emallgoodsentity.entity.params;

import com.emall.emallweb.entity.params.BasePageParam;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("广告分页查询参数")
public class AdvertisePageParam extends BasePageParam {

    @ApiModelProperty(value = "描述")
    private String name;
    @ApiModelProperty(value = "状态")
    private Integer status;
    @ApiModelProperty(value = "广告开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date start_time;
    @ApiModelProperty(value = "广告结束时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date end_time;

}
