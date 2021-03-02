package com.emall.emallweb.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("emall_advertise")
public class AdvertiseBannerPo extends BasePo {

    @ApiModelProperty(value = "广告描述")
    private String name;
    @ApiModelProperty(value = "广告位置")
    private Integer position;
    @ApiModelProperty(value = "广告图片")
    private String picture;
    @ApiModelProperty(value = "广告开始时间")
    private LocalDateTime start_time;
    @ApiModelProperty(value = "广告结束时间")
    private LocalDateTime end_time;
    @ApiModelProperty(value = "广告状态，0-上线，1-下线")
    private Integer status;
    @ApiModelProperty(value = "广告浏览量")
    private Integer pageview;
    @ApiModelProperty(value = "广告跳转地址")
    private String direct_url;
    @ApiModelProperty(value = "备注")
    private String note;
    @ApiModelProperty(value = "广告排序")
    private Integer sort;

}
