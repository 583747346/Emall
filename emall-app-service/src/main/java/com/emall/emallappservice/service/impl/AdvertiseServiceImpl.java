package com.emall.emallappservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.emallappservice.entity.vo.AdvertiseVo;
import com.emall.emallappservice.mapper.AdvertiseMapper;
import com.emall.emallappservice.service.IAdvertiseService;
import com.emall.emallweb.entity.po.AdvertiseBannerPo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdvertiseServiceImpl extends ServiceImpl<AdvertiseMapper, AdvertiseBannerPo> implements IAdvertiseService {
    @Override
    public List<AdvertiseVo> getAdvertisePics() {
        QueryWrapper<AdvertiseBannerPo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("flag", 1);
        return this.list(queryWrapper).stream().map(AdvertiseVo::new).collect(Collectors.toList());
    }
}
