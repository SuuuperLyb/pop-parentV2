package com.offway.lxm.service;

import com.offway.common.entity.R;
import com.offway.lxm.dto.*;

/**
 * 用户订单详情模块
 */
public interface TOrderService {
    /**
     * 查看所有订单
     * @param token
     * @return
     */
    R getall(String token);

    /**
     * 查看所有未支付订单
     * @param token
     * @return
     */
    R nopay(String token);
    /**
     * 查看所有待发货订单
     * @param token
     * @return
     */
    R noshipment(String token);

    /**
     * 查看所有待收货订单
     * @param token
     * @return
     */
    R noreceive(String token);
    /**
     * 查看所有待评价订单
     * @param token
     * @return
     */
    R nocomment(String token);
    /**
     * 删除某一条订单
     * @param delOneOrderDto
     * @return
     */
    R delone(DelOneOrderDto delOneOrderDto);

    /**
     * 删除多条订单
     * @param delManyOrderDto
     * @return
     */
    R delmany(DelManyOrderDto delManyOrderDto);

    /**
     * 修改待支付订单状态
     * @param updateOrderDto
     * @return
     */
    R updatenopay(UpdateOrderDto updateOrderDto);

    /**
     * 把待发货订单修改为待收货订单
     * @param updateOrderDto
     * @return
     */
    R updatenoshipment(UpdateOrderDto updateOrderDto);

    /**
     * 把待收货订单修改为待评价订单
     * @param updateOrderDto
     * @return
     */
    R updatenoreceive(UpdateOrderDto updateOrderDto);

    /**
     * 发表评价
     * 同时把待评价订单修改为已评价订单
     * @param orderCommitDto
     * @return
     */
    R updatenocomment(OrderCommitDto orderCommitDto);

    /**
     * 查看当前订单的订单详情
     * @param getOrderDetailDto
     * @return
     */
    R getorderdetail(GetOrderDetailDto getOrderDetailDto);
}
