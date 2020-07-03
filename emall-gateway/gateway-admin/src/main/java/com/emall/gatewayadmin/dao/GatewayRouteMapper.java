package com.emall.gatewayadmin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.emall.gatewayadmin.entity.po.GatewayRoutePo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface GatewayRouteMapper extends BaseMapper<GatewayRoutePo> {
}