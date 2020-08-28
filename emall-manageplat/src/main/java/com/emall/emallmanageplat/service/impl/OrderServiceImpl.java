package com.emall.emallmanageplat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.emallmanageplat.entity.params.OrderQueryParam;
import com.emall.emallweb.entity.po.EmallOrderPo;
import com.emall.emallmanageplat.entity.vo.EmallOrderVo;
import com.emall.emallmanageplat.mapper.OrderMapper;
import com.emall.emallmanageplat.service.IOrderService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, EmallOrderPo> implements IOrderService {

    /**
     * 条件分页查询订单信息
     *
     * @param orderQueryParam
     * @return
     */
    @Override
    public IPage<EmallOrderVo> getOrders(OrderQueryParam orderQueryParam) {
        QueryWrapper<EmallOrderPo> queryWrapper = new QueryWrapper<>();
        if (orderQueryParam != null) {
            queryWrapper.eq(StringUtils.isNotEmpty(orderQueryParam.getOrderSn()), "order_sn", orderQueryParam.getOrderSn());
            queryWrapper.eq(StringUtils.isNotEmpty(orderQueryParam.getReceiverName()), "receiver_name", orderQueryParam.getReceiverName());
            queryWrapper.eq(StringUtils.isNotEmpty(orderQueryParam.getOrderStatus()), "order_status", orderQueryParam.getOrderStatus());
            queryWrapper.eq(StringUtils.isNotEmpty(orderQueryParam.getOrderType()), "order_type", orderQueryParam.getOrderType());
            queryWrapper.eq(StringUtils.isNotEmpty(orderQueryParam.getConfirmStatus()), "confirm_status", orderQueryParam.getConfirmStatus());
            queryWrapper.eq(orderQueryParam.getCreateTime() == null, "create_time", orderQueryParam.getCreateTime());

        }
        IPage<EmallOrderPo> page = this.page(orderQueryParam.getPage(), queryWrapper);
        return page.convert(EmallOrderVo::new);
    }

    /**
     * 根据订单id获取订单详情
     * @param oid
     * @return
     */
    @Override
    public EmallOrderVo getOrdersById(String oid) {
        //获取订单信息
        EmallOrderPo emallOrderPo = this.getById(oid);
        //TODO 获取订单中商品信息

        return null;
    }
}
