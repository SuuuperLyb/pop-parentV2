package com.offway.lxm.dao;

import com.offway.lxm.entity.Order;

import java.util.List;

/**
 * 用户订单模块
 */

public interface OrderMapper {

    /**
     * 查询所有订单
     * @param uId
     * @return
     */
    List<Order> getall(Integer uId);

    /**
     * 查看所有待支付订单
     * @param uId
     * @return
     */
    List<Order> nopay( Integer uId);

    /**
     * 查看所有待发货订单
     * @param uId
     * @return
     */
    List<Order> noshipment(Integer uId);

    /**
     * 查看所有待收货订单
     * @param uId
     * @return
     */
    List<Order> noreceive(Integer uId);

    /**
     * 查看所有待评价订单
     * @param uId
     * @return
     */
    List<Order> nocomment(Integer uId);
}
