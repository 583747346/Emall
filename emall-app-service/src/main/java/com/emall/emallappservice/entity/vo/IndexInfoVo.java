package com.emall.emallappservice.entity.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("首页相关信息")
public class IndexInfoVo {

    //banner广告图片
    private List<String> advertisePics;

}
