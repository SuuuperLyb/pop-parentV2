package com.offway.lxm.service;

import com.offway.common.entity.R;
import com.offway.lxm.dto.DelManyOrderDto;
import com.offway.lxm.dto.DelOneOrderDto;

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



}
