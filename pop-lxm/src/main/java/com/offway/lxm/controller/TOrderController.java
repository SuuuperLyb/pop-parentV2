package com.offway.lxm.controller;

import com.offway.common.entity.R;
import com.offway.lxm.dto.*;
import com.offway.lxm.service.TOrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author LXM
 * 用户订单详情模块
 * @Date 2020/6/24 0024
 */
@RestController
public class TOrderController {
    @Resource
    private TOrderService orderService;

    /**
     * 查看所有订单
     * @param token
     * @return
     */
    @PostMapping("api/order/getall.do")
    public R getall(String token){
        return orderService.getall(token);
    }

    /**
     * 查看所有未支付订单
     * @param token
     * @return
     */
    @PostMapping("api/order/nopay.do")
    public R nopay(String token){
        return orderService.nopay(token);
    }

    /**
     * 查看所有待发货订单
     * @param token
     * @return
     */
    @PostMapping("api/order/noshipment.do")
    public R noshipment(String token){
        return orderService.noshipment(token);
    }

    /**
     * 查看所有待收货订单
     * @param token
     * @return
     */
    @PostMapping("api/order/noreceive.do")
    public R noreceive(String token){
        return orderService.noreceive(token);
    }

    /**
     * 查看所有待评价订单
     * @param token
     * @return
     */
    @PostMapping("api/order/nocomment.do")
    public R nocomment(String token){
        return orderService.nocomment(token);
    }

    /**
     * 删除某一条订单
     * @param delOneOrderDto
     * @return
     */
    @PostMapping("api/order/delone.do")
    public R delone(@RequestBody DelOneOrderDto delOneOrderDto){
        return orderService.delone(delOneOrderDto);
    }

    /**
     * 删除多条订单
     * @param delManyOrderDto
     * @return
     */
    @PostMapping("api/order/delmany.do")
    public R delmany(@RequestBody DelManyOrderDto delManyOrderDto){
        return orderService.delmany(delManyOrderDto);
    }
    /**
     * 修改待支付订单状态
     * @param updateOrderDto
     * @return
     */
    @PostMapping("api/order/updatenopay.do")
    public R updatenopay(UpdateOrderDto updateOrderDto){
        return orderService.updatenopay(updateOrderDto);
    }

    /**
     * 把待发货订单修改为待收货订单
     * @param updateOrderDto
     * @return
     */
    @PostMapping("api/order/updatenoshipment.do")
    public R updatenoshipment(UpdateOrderDto updateOrderDto){
        return orderService.updatenoshipment(updateOrderDto);
    }

    /**
     * 把待收货订单修改为待评价订单
     * @param updateOrderDto
     * @return
     */
    @PostMapping("api/order/updatenoreceive.do")
    public R updatenoreceive(UpdateOrderDto updateOrderDto){
        return orderService.updatenoreceive(updateOrderDto);
    }

    /**
     * 发表评价
     * 同时把待评价订单修改为已评价订单
     * @param orderCommitDto
     * @return
     */
    @PostMapping("api/order/updatenocomment.do")
    public R updatenocomment(OrderCommitDto orderCommitDto){
        return orderService.updatenocomment(orderCommitDto);
    }

    /**
     * 查看当前订单的订单详情
     * @param getOrderDetailDto
     * @return
     */
    @PostMapping("api/order/getorderdetail.do")
    public R getorderdetail(GetOrderDetailDto getOrderDetailDto){
        return orderService.getorderdetail(getOrderDetailDto);
    }
}
