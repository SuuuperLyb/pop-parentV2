package com.offway.lxm.controller;

import com.offway.common.entity.R;
import com.offway.lxm.dto.DelManyOrderDto;
import com.offway.lxm.dto.DelOneOrderDto;
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
}
