package com.emall.emallweb.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.emall.emallweb.entity.po.BaseProcessPo;
import lombok.Data;

@Data
@TableName("emall_advertise")
public class AdvertiseBannerPo extends BaseProcessPo {

    private String pic;

}
