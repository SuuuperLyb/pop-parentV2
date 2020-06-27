package com.offway.lxm.service;

import com.offway.common.entity.R;
import com.offway.lxm.dto.DeleteShoppingCarDto;
import com.offway.lxm.dto.DelmanyDto;
import com.offway.lxm.dto.UpdateGoodsNumDto;

/**
 * 用户购物车模块
 */
public interface TShoppingCarService {
    /**
     * 查询购物车的所有商品
     * @param token
     * @return
     */
    R selectAll(String token);

    /**
     * 修改购物车商品数量
     * @param updateGoodsNumDto
     * @return
     */
    R updatenum(UpdateGoodsNumDto updateGoodsNumDto);

    /**
     * 删除购物车的某个商品
     * @param deleteShoppingCarDto
     * @return
     */
    R delone(DeleteShoppingCarDto deleteShoppingCarDto);

    /**
     * 批量删除购物车的商品
     * @param delmanyDto
     * @return
     */
    R delmany(DelmanyDto delmanyDto);
}
