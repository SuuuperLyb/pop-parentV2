package com.offway.popzgy.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.offway.common.entity.R;
import com.offway.common.entity.TOrder;
import com.offway.common.util.Rutil;
import com.offway.popzgy.dto.OrderDto;
import com.offway.popzgy.service.TOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;


import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@CrossOrigin
@RestController
public class TOrderControllerzgy {

    @Autowired @Qualifier("orderServicezgy")

    private TOrderService orderService;
    //查询今日订单数
    @GetMapping("order/todayOrderSum.do")
    public R todayOrderSum(){
        return orderService.todayOrderSum();
    }
    //查询今日总销售额
    @GetMapping("order/todaySumMoney.do")
    public R todaySumMoney() {return orderService.todaySumMoney();}
    //查询昨日总销售额
    @GetMapping("order/yesterdaySumMoney.do")
    public R yesterdaySumMoney() {return orderService.yesterdaySumMoney();}
    //查询待付款订单
    @GetMapping("order/noPayOrderNum.do")
    public R noPayOrderNum(){
        return orderService.noPayOrderNum();
    }
    //查询待发货订单
    @GetMapping("order/noDeliverOrderNum.do")
    public R noDeliverOrderNum(){
        return orderService.noDeliverOrderNum();
    }
    //查询待收货订单
    @GetMapping("order/noGetOrderNum.do")
    public R noGetOrderNum(){
        return orderService.noGetOrderNum();
    }
    //查询待评价订单
    @GetMapping("order/noEvaluateOederNum.do")
    public R noEvaluateOrderNum(){
        return orderService.noEvaluateOrderNum();
    }

    //修改订单是否存在状态
    @PutMapping ("order/updateOrderStatuById.do")
    public R updateOrderStatuById(@RequestParam("oId") String oId){
        return orderService.updateOrderStatuById(oId);
    }

    //查看订单
    @GetMapping("order/selectOrderById.do")
    public R selectOrderById(@RequestParam("oId") String oId){
        return orderService.selectOrderById(oId);
    }
    //修改订单数据
    @PutMapping("order/updateOrderMsgById.do")
    public R updateOrderMsgById(@RequestBody TOrder tOrder){

        return orderService.updateOrderMsgById(tOrder);
    }
    //分页查询订单
    @PutMapping("order/findOrderByMsg.do")
    public R findOrderByMsg(@RequestBody OrderDto orderDto,@RequestParam(value = "currPage",defaultValue = "1") String currPage) {
        PageHelper.startPage(Integer.valueOf(currPage),5);
        List<TOrder> tOrderList=orderService.findOrderByMsg(orderDto);
        PageInfo<TOrder> pageInfo=new PageInfo<>(tOrderList);
        return Rutil.Ok(pageInfo);
    }
    //分页查询订单
    @GetMapping("order/findOrderByPage.do")
    public R findOrderByPage(@RequestParam(value = "currPage",defaultValue = "1") String currPage) {
        PageHelper.startPage(Integer.parseInt(currPage),5);
        List<TOrder> tOrderList=orderService.findOrderByPage();
        PageInfo<TOrder> pageInfo=new PageInfo<>(tOrderList);
        return Rutil.Ok(pageInfo);
    }
}
