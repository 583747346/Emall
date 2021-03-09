package com.emall.emallappservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.emallappservice.entity.vo.ProductTopicVo;
import com.emall.emallappservice.mapper.ProductTopicMapper;
import com.emall.emallappservice.service.IProductTopicService;
import com.emall.emallgoodsentity.entity.po.ProductTopicPo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductTopicServiceImpl extends ServiceImpl<ProductTopicMapper, ProductTopicPo> implements IProductTopicService {

    /**
     * 获取商品主题信息
     * @return
     */
    @Override
    public List<ProductTopicVo> getProductTopics() {
        QueryWrapper<ProductTopicPo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status", 0);
        return this.list(queryWrapper).stream().map(ProductTopicVo::new).collect(Collectors.toList());
    }
}
