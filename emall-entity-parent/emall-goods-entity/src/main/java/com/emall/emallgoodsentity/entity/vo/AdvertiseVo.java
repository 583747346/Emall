package com.emall.emallgoodsentity.entity.vo;

import com.emall.emallweb.entity.po.AdvertiseBannerPo;
import com.emall.emallweb.entity.vo.BaseVo;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
@ApiModel("广告信息视图")
public class AdvertiseVo extends BaseVo {


    public AdvertiseVo(AdvertiseBannerPo advertiseBannerPo) {
        BeanUtils.copyProperties(advertiseBannerPo, this);
    }
}
