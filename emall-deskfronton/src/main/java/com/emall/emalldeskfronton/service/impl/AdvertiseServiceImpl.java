package com.emall.emalldeskfronton.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.emalldeskfronton.entity.po.AdvertisePo;
import com.emall.emalldeskfronton.mapper.AdvertiseMapper;
import com.emall.emalldeskfronton.service.IAdvertiseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdvertiseServiceImpl extends ServiceImpl<AdvertiseMapper, AdvertisePo> implements IAdvertiseService {
    @Override
    public List<String> getAdvertisePics() {
        QueryWrapper<AdvertisePo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("flag", 1);
        return this.list(queryWrapper).stream().map(advertisePo -> advertisePo.getPic()).collect(Collectors.toList());
    }
}
