package com.emall.emallappservice.service;

import com.emall.emallappservice.entity.vo.AdvertiseVo;

import java.util.List;


public interface IAdvertiseService {
    //轮播广告
    List<AdvertiseVo> getAdvertisePics();
}
