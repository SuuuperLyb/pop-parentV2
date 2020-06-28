package com.offway.lxm.controller;

import com.offway.common.entity.R;
import com.offway.lxm.dto.DeleteShoppingCarDto;
import com.offway.lxm.dto.DelmanyDto;
import com.offway.lxm.dto.UpdateGoodsNumDto;
import com.offway.lxm.service.TShoppingCarService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author LXM
 * 用户购物车模块
 * @Date 2020/6/25 0025
 */
@RestController
@CrossOrigin
public class TShoppingCarController {
    @Resource
    private TShoppingCarService tShoppingCarService;

    /**
     * 查询购物车的所有商品
     * @param token
     * @return
     */
    @PostMapping("api/tshoppingcar/selectAll.do")
    public R selectAll(String token){
        return tShoppingCarService.selectAll(token);
    }

    /**
     * 修改购物车商品数量
     * @param updateGoodsNumDto
     * @return
     */
    @PostMapping("api/tshoppingcar/updatenum.do")
    public R updatenum(@RequestBody UpdateGoodsNumDto updateGoodsNumDto){
        return tShoppingCarService.updatenum(updateGoodsNumDto);
    }

    /**
     * 删除购物车的某个商品
     * @param deleteShoppingCarDto
     * @return
     */
    @PostMapping("api/tshoppingcar/delone.do")
    public R delone(@RequestBody DeleteShoppingCarDto deleteShoppingCarDto){
        return tShoppingCarService.delone(deleteShoppingCarDto);
    }

    /**
     * 批量删除购物车的商品
     * @param delmanyDto
     * @return
     */
    @PostMapping("api/tshoppingcar/delmany.do")
    public R delmany(@RequestBody DelmanyDto delmanyDto){
        return tShoppingCarService.delmany(delmanyDto);
    }
}
