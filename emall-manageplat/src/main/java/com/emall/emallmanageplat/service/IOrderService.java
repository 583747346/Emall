package com.emall.emallmanageplat.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.emall.emallmanageplat.entity.params.OrderQueryParam;
import com.emall.emallmanageplat.entity.vo.EmallOrderVo;

public interface IOrderService {
    IPage<EmallOrderVo> getOrders(OrderQueryParam orderQueryParam);

    EmallOrderVo getOrdersById(String oid);
}
