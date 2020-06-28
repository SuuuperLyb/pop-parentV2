package com.offway.popzgy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.offway.common.entity.R;
import com.offway.common.entity.TOrder;
import com.offway.popzgy.dto.OrderDto;

import java.util.List;

public interface TOrderService extends IService<TOrder> {
    //查询今日订单数
    R todayOrderSum();

    //查询今日总销售额
    R todaySumMoney();

    //查询昨日总销售额
    R yesterdaySumMoney();

    //查询待付款订单
    R noPayOrderNum();

    //查询待发货订单
    R noDeliverOrderNum();

    //查询待收货订单
    R noGetOrderNum();

    //查询待评价订单
    R noEvaluateOrderNum();

    //修改订单有效状态
    R updateOrderStatuById(String oId);
    //修改订单信息
    R updateOrderMsgById(TOrder tOrder);
    //查询订单详情
    R selectOrderById(String oId);
    //分页查询订单
    List<TOrder> findOrderByMsg(OrderDto orderDto);

    List<TOrder> findOrderByPage();
}
