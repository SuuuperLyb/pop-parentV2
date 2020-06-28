package com.offway.lxm.service.impl;

import com.alibaba.fastjson.JSON;
import com.offway.common.conf.RedisKeyConfig;
import com.offway.common.entity.R;
import com.offway.common.entity.TUser;
import com.offway.common.mapper.TShoppingCarMapper;
import com.offway.common.three.JedisCore;
import com.offway.common.util.Rutil;
import com.offway.lxm.dto.DeleteShoppingCarDto;
import com.offway.lxm.dto.DelmanyDto;
import com.offway.lxm.dto.UpdateGoodsNumDto;
import com.offway.lxm.entity.ShoppingCar;
import com.offway.lxm.dao.ShoppingCarMapper;
import com.offway.lxm.service.TShoppingCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author LXM
 * 用户购物车模块
 * @Date 2020/6/25 0025
 */
@Service("TShoppingCarServiceImpllxm")
public class TShoppingCarServiceImpl implements TShoppingCarService {
    @Resource
    private JedisCore jedisCore;
    @Resource
    private ShoppingCarMapper shoppingCarMapper;
    @Resource
    private TShoppingCarMapper tShoppingCarMapper;
    /**
     * 查询购物车的所有商品
     * @param token
     * @return
     */
    @Override
    public R selectAll(String token) {
        if(jedisCore.isExist(RedisKeyConfig.LOGIN_USER+token)==false){
            return Rutil.err("请登录");
        }else {
            TUser user = JSON.parseObject(jedisCore.getVal(RedisKeyConfig.LOGIN_USER+token), TUser.class);
            List<ShoppingCar> shoppingCarList=shoppingCarMapper.selectAll(user.getuId());
            return Rutil.Ok(shoppingCarList);
        }
    }

    /**
     * 修改购物车商品数量
     * @param updateGoodsNumDto
     * @return
     */
    @Override
    public R updatenum(UpdateGoodsNumDto updateGoodsNumDto) {
        if(jedisCore.isExist(RedisKeyConfig.LOGIN_USER+updateGoodsNumDto.getToken())==false){
            return Rutil.err("请登录");
        }else {
            //判断要修改的商品数量是否大于最大库存
            int count=shoppingCarMapper.selectgoodsCount(updateGoodsNumDto.getScId());
            //判断要修改的商品数量是否大于库存
            if(updateGoodsNumDto.getgNum()>count&&updateGoodsNumDto.getgNum()<1){
                return Rutil.err("不能超过最大数量并且不能小于1");
            }else{
                if(shoppingCarMapper.updatenum(updateGoodsNumDto.getScId(),updateGoodsNumDto.getgNum())>0){
                    return Rutil.Ok();
                }else {
                    return Rutil.err("修改失败");
                }
            }
        }
    }

    /**
     * 删除购物车的某个商品
     * @param deleteShoppingCarDto
     * @return
     */
    @Override
    public R delone(DeleteShoppingCarDto deleteShoppingCarDto) {
        if(jedisCore.isExist(RedisKeyConfig.LOGIN_USER+deleteShoppingCarDto.getToken())==false){
            return Rutil.err("请登录");
        }else {
            if(tShoppingCarMapper.deleteById(deleteShoppingCarDto.getScId())>0){
                return Rutil.Ok();
            }else {
                return Rutil.err("删除失败");
            }
        }

    }

    /**
     * 批量删除购物车的商品
     * @param delmanyDto
     * @return
     */
    @Override
    public R delmany(DelmanyDto delmanyDto) {
        if(jedisCore.isExist(RedisKeyConfig.LOGIN_USER+delmanyDto.getToken())==false){
            return Rutil.err("请登录");
        }else {
            if(tShoppingCarMapper.deleteBatchIds(delmanyDto.getScidlist())>0){
                return Rutil.Ok();
            }else {
                return Rutil.err("删除失败");
            }
        }
    }
}
