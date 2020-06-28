package com.offway.lxm.service.impl;

import com.alibaba.fastjson.JSON;
import com.offway.common.conf.RedisKeyConfig;
import com.offway.common.entity.R;
import com.offway.common.entity.TCommentUser;
import com.offway.common.entity.TOrder;
import com.offway.common.entity.TUser;
import com.offway.common.mapper.TCommentUserMapper;
import com.offway.common.mapper.TOrderMapper;
import com.offway.common.three.JedisCore;
import com.offway.common.util.Rutil;
import com.offway.lxm.dto.*;
import com.offway.lxm.entity.Order;
import com.offway.lxm.dao.OrderMapper;
import com.offway.lxm.service.TOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.List;

/**
 * @Author LXM
 * 用户订单详情模块
 * @Date 2020/6/24 0024
 */
@Service("TOrderServiceImpllxm")
public class TOrderServiceImpl implements TOrderService {
    @Resource
    private JedisCore jedisCore;
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private TOrderMapper tOrderMapper;
    @Resource
    private TCommentUserMapper tCommentUserMapper;
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

    /**
     * 修改待支付订单状态
     * @param updateOrderDto
     * @return
     */
    @Override
    public R updatenopay(UpdateOrderDto updateOrderDto) {
        if(jedisCore.isExist(RedisKeyConfig.LOGIN_USER+updateOrderDto.getToken())==false){
            return Rutil.err("请登录");
        }else {
            if(orderMapper.updatenopay(updateOrderDto.getoId())>0){
                return Rutil.Ok();
            }else{
                return Rutil.err("支付失败");
            }
        }
    }

    /**
     * 把待发货订单修改为待收货订单
     * @param updateOrderDto
     * @return
     */
    @Override
    public R updatenoshipment(UpdateOrderDto updateOrderDto) {
        if(jedisCore.isExist(RedisKeyConfig.LOGIN_USER+updateOrderDto.getToken())==false){
            return Rutil.err("请登录");
        }else {
            if(orderMapper.updatenoshipment(updateOrderDto.getoId())>0){
                return Rutil.Ok();
            }else{
                return Rutil.err("支付失败");
            }
        }
    }

    /**
     * 把待收货订单修改为待评价订单
     * @param updateOrderDto
     * @return
     */
    @Override
    public R updatenoreceive(UpdateOrderDto updateOrderDto) {
        if(jedisCore.isExist(RedisKeyConfig.LOGIN_USER+updateOrderDto.getToken())==false){
            return Rutil.err("请登录");
        }else {
            if(orderMapper.updatenoreceive(updateOrderDto.getoId())>0){
                return Rutil.Ok();
            }else{
                return Rutil.err("支付失败");
            }
        }
    }

    /**
     * 发表评价
     * 同时把待评价订单修改为已评价订单
     * @param orderCommitDto
     * @return
     */
    @Override
    @Transactional//开启事务
    public R updatenocomment(OrderCommitDto orderCommitDto) {
        if(jedisCore.isExist(RedisKeyConfig.LOGIN_USER+orderCommitDto.getToken())==false){
            return Rutil.err("请登录");
        }else {
            TUser user = JSON.parseObject(jedisCore.getVal(RedisKeyConfig.LOGIN_USER+orderCommitDto.getToken()), TUser.class);
            //根据订单id找到商品id
            TOrder tOrder=tOrderMapper.selectById(orderCommitDto.getoId());
            TCommentUser commentUser=new TCommentUser();
            commentUser.setuId(user.getuId());
            commentUser.setcCommentDate(LocalDate.now());
            commentUser.setcCommentContent(orderCommitDto.getCommentContent());
            commentUser.setcIsvalid(1);
            commentUser.setGoodsId(tOrder.getgId());
            //向评论表插入数据，并且改变订单的状态
            if(tCommentUserMapper.insert(commentUser)>0&&orderMapper.updatenocomment(orderCommitDto.getoId())>0){
                return Rutil.Ok();
            }else{
                return Rutil.err("发表评论失败");
            }
        }
    }

    /**
     * 查看当前订单的订单详情
     * @param getOrderDetailDto
     * @return
     */
    @Override
    public R getorderdetail(GetOrderDetailDto getOrderDetailDto) {
        if(jedisCore.isExist(RedisKeyConfig.LOGIN_USER+getOrderDetailDto.getToken())==false){
            return Rutil.err("请登录");
        }else {
            Order order=orderMapper.getorderdetail(getOrderDetailDto.getoId());
            return Rutil.Ok(order);
        }
    }
}
