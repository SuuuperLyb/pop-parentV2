package com.offway.lxm.service.impl;

import com.alibaba.fastjson.JSON;
import com.offway.common.conf.RedisKeyConfig;
import com.offway.common.entity.R;
import com.offway.common.entity.TUser;
import com.offway.common.mapper.TOrderMapper;
import com.offway.common.three.JedisCore;
import com.offway.common.util.Rutil;
import com.offway.lxm.dto.DelManyOrderDto;
import com.offway.lxm.dto.DelOneOrderDto;
import com.offway.lxm.entity.Order;
import com.offway.lxm.dao.OrderMapper;
import com.offway.lxm.service.TOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author LXM
 * 用户订单详情模块
 * @Date 2020/6/24 0024
 */
@Service
public class TOrderServiceImpl implements TOrderService {
    @Resource
    private JedisCore jedisCore;
    @Autowired(required = false)
    private OrderMapper orderMapper;
    @Resource
    private TOrderMapper tOrderMapper;
    /**
     * 查看所有订单
     * @param token
     * @return
     */
    @Override
    public R getall(String token) {
        if(jedisCore.isExist(RedisKeyConfig.LOGIN_USER+token)==false){
            return Rutil.err("请登录");
        }else {
            TUser user = JSON.parseObject(jedisCore.getVal(RedisKeyConfig.LOGIN_USER+token), TUser.class);
            List<Order> orderList=orderMapper.getall(user.getuId());
            return Rutil.Ok(orderList);
        }
    }

    /**
     * 查看所有未支付订单
     * @param token
     * @return
     */
    @Override
    public R nopay(String token) {
        if(jedisCore.isExist(RedisKeyConfig.LOGIN_USER+token)==false){
            return Rutil.err("请登录");
        }else {
            TUser user = JSON.parseObject(jedisCore.getVal(RedisKeyConfig.LOGIN_USER+token), TUser.class);
            List<Order> orderList=orderMapper.nopay(user.getuId());
            return Rutil.Ok(orderList);
        }
    }

    /**
     * 查看所有待发货订单
     * @param token
     * @return
     */
    @Override
    public R noshipment(String token) {
        if(jedisCore.isExist(RedisKeyConfig.LOGIN_USER+token)==false){
            return Rutil.err("请登录");
        }else {
            TUser user = JSON.parseObject(jedisCore.getVal(RedisKeyConfig.LOGIN_USER+token), TUser.class);
            List<Order> orderList=orderMapper.noshipment(user.getuId());
            return Rutil.Ok(orderList);
        }
    }

    /**
     * 查看所有待收货订单
     * @param token
     * @return
     */
    @Override
    public R noreceive(String token) {
        if(jedisCore.isExist(RedisKeyConfig.LOGIN_USER+token)==false){
            return Rutil.err("请登录");
        }else {
            TUser user = JSON.parseObject(jedisCore.getVal(RedisKeyConfig.LOGIN_USER+token), TUser.class);
            List<Order> orderList=orderMapper.noreceive(user.getuId());
            return Rutil.Ok(orderList);
        }
    }

    /**
     * 查看所有待评价订单
     * @param token
     * @return
     */
    @Override
    public R nocomment(String token) {
        if(jedisCore.isExist(RedisKeyConfig.LOGIN_USER+token)==false){
            return Rutil.err("请登录");
        }else {
            TUser user = JSON.parseObject(jedisCore.getVal(RedisKeyConfig.LOGIN_USER+token), TUser.class);
            List<Order> orderList=orderMapper.nocomment(user.getuId());
            return Rutil.Ok(orderList);
        }
    }

    /**
     * 删除某一条订单
     * @param delOneOrderDto
     * @return
     */
    @Override
    public R delone(DelOneOrderDto delOneOrderDto) {
        if(jedisCore.isExist(RedisKeyConfig.LOGIN_USER+delOneOrderDto.getToken())==false){
            return Rutil.err("请登录");
        }else {
            if(tOrderMapper.deleteById(delOneOrderDto.getoId())>0){
                return Rutil.Ok();
            }else {
                return Rutil.err("删除失败");
            }
        }
    }

    /**
     * 删除多条订单
     * @param delManyOrderDto
     * @return
     */
    @Override
    public R delmany(DelManyOrderDto delManyOrderDto) {
        if(jedisCore.isExist(RedisKeyConfig.LOGIN_USER+delManyOrderDto.getToken())==false){
            return Rutil.err("请登录");
        }else {
            if(tOrderMapper.deleteBatchIds(delManyOrderDto.getoIdlist())>0){
                return Rutil.Ok();
            }else {
                return Rutil.err("删除失败");
            }
        }
    }
}
