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
    List<Order> nopay(Integer uId);

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

    /**
     * 修改待支付订单状态
     * @param oId
     * @return
     */
    int updatenopay(Integer oId);

    /**
     * 把待发货订单修改为待收货订单
     * @param oId
     * @return
     */
    int updatenoshipment(Integer oId);

    /**
     * 把待收货订单修改为待评价订单
     * @param oId
     * @return
     */
    int updatenoreceive(Integer oId);

    /**
     * 把待评价订单改为已评价订单
     * @param oId
     * @return
     */
    int updatenocomment(Integer oId);

    /**
     * 查看当前订单的订单详情
     * @param oId
     * @return
     */
    Order getorderdetail(int oId);
}
