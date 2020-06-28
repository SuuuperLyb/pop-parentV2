package com.offway.popzgy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.offway.common.entity.R;
import com.offway.common.entity.TOrder;
import com.offway.common.util.Rutil;
import com.offway.popzgy.dao.OrderMapper;
import com.offway.popzgy.dto.OrderDto;
import com.offway.popzgy.service.TOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class TOrderServiceImpl extends ServiceImpl<OrderMapper, TOrder> implements TOrderService {

    @Autowired
    private OrderMapper orderMapper;


    //查询今日订单数
    @Override
    public R todayOrderSum() {
        Integer todayOrderSum=orderMapper.todayOrderSum();
        return Rutil.Ok(todayOrderSum);
    }


    //查询今日总销售额
    @Override
    public R todaySumMoney() {
        Double todaySumMoney=orderMapper.todaySumMoney();
        return Rutil.Ok(todaySumMoney);
    }


    //查询昨日总销售额
    @Override
    public R yesterdaySumMoney() {
        Double yesterdaySumMoney=orderMapper.yesterdaySumMoney();
        return Rutil.Ok(yesterdaySumMoney);
    }


    //查询待付款订单
    @Override
    public R noPayOrderNum() {
        Integer noPayOrderNum=orderMapper.selectCount(new QueryWrapper<TOrder>().eq("o_type", 1).eq("o_status",1));
        return Rutil.Ok(noPayOrderNum);
    }


    //查询待发货订单
    @Override
    public R noDeliverOrderNum() {
        Integer noDeliverOrderNum=orderMapper.selectCount(new QueryWrapper<TOrder>().eq("o_type", 2).eq("o_status",1));
        return Rutil.Ok(noDeliverOrderNum);
    }


    //查询待收货订单
    @Override
    public R noGetOrderNum() {
        Integer noDeliverOrderNum=orderMapper.selectCount(new QueryWrapper<TOrder>().eq("o_type", 3).eq("o_status",1));
        return Rutil.Ok(noDeliverOrderNum);
    }


    //查询待评价订单
    @Override
    public R noEvaluateOrderNum() {
        Integer noEvaluateOrderNum=orderMapper.selectCount(new QueryWrapper<TOrder>().eq("o_type", 4).eq("o_status",1));
        return Rutil.Ok(noEvaluateOrderNum);
    }

    //修改订单是否有效
    @Override
    public R updateOrderStatuById(String oId) {
        TOrder tOrder=new TOrder();
        tOrder.setoId(Integer.valueOf(oId));
        tOrder.setoStatus(0);
        orderMapper.updateById(tOrder);
        return Rutil.Ok("删除成功",null);

    }



    //修改定单数据
    @Override
    @Transactional //启用事务
    public R updateOrderMsgById(TOrder tOrder) {
        orderMapper.updateById(tOrder);
        return Rutil.Ok("修改成功",orderMapper.selectById(tOrder.getcId()));

    }

    //查询订单
    @Override
    public R selectOrderById(String oId) {
        return Rutil.Ok(orderMapper.selectById(Integer.valueOf(oId)));
    }

    //分页查询订单
    @Override
    public List<TOrder> findOrderByMsg(OrderDto orderDto) {
        return orderMapper.selectList(new QueryWrapper<TOrder>().eq("o_status", 1).eq("o_num",orderDto.getONum()).eq("o_type",orderDto.getOType()).eq("o_create_time",orderDto.getOCreateTime()));
    }

    @Override
    public List<TOrder> findOrderByPage() {
        return orderMapper.selectList(new QueryWrapper<TOrder>().eq("o_status", 1));
    }


}
