package com.emall.emallappservice.entity.vo;

import com.emall.emallweb.entity.po.AdvertiseBannerPo;
import com.emall.emallweb.entity.vo.BaseVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class AdvertiseVo extends BaseVo<AdvertiseBannerPo> {

    @ApiModelProperty(value = "广告描述")
    private String name;
    @ApiModelProperty(value = "广告位置,0-PC首页,1-APP首页")
    private Integer position;
    @ApiModelProperty(value = "广告图片")
    private String picture;
    @ApiModelProperty(value = "广告跳转地址")
    private String direct_url;

    public AdvertiseVo(AdvertiseBannerPo advertiseBannerPo){
        BeanUtils.copyProperties(advertiseBannerPo,this);
    }

}
