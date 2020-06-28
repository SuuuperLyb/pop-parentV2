package com.offway.lxm.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.offway.common.conf.RedisKeyConfig;
import com.offway.common.entity.R;
import com.offway.common.entity.TUser;
import com.offway.common.entity.TUserlike;
import com.offway.common.mapper.TUserlikeMapper;
import com.offway.common.three.JedisCore;
import com.offway.common.util.Rutil;
import com.offway.lxm.dto.DeleteUserlikeDto;
import com.offway.lxm.entity.TUserlikeGoods;
import com.offway.lxm.entity.TUserlikeStarStyle;
import com.offway.lxm.entity.TUserlikeStore;
import com.offway.lxm.dao.LikeMapper;
import com.offway.lxm.service.TUserlikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author LXM
 * 用户喜欢模块
 * @Date 2020/6/24 0024
 */
@Service("TUserlikeServiceImpllxm")
public class TUserlikeServiceImpl implements TUserlikeService {
    @Resource
    private JedisCore jedisCore;
    @Resource
    private LikeMapper likemapper;
    @Resource
    private TUserlikeMapper userlikeMapper;




    /**
     * 查询用户喜欢的所有商品
     * @param token
     * @return
     */
    @Override
    public R getgoods(String token) {
        if(jedisCore.isExist(RedisKeyConfig.LOGIN_USER+token)==false){
           return Rutil.err("请登录");
        }else {
            TUser user = JSON.parseObject(jedisCore.getVal(RedisKeyConfig.LOGIN_USER+token), TUser.class);
            List<TUserlikeGoods> userlikeGoodss = likemapper.selectgoods(user.getuId());
            return Rutil.Ok(userlikeGoodss);
        }
    }

    /**
     * 查询用户喜欢的所有店铺
     * @param token
     * @return
     */
    @Override
    public R getstores(String token) {
        if(jedisCore.isExist(RedisKeyConfig.LOGIN_USER+token)==false){
            return Rutil.err("请登录");
        }else {
            TUser user = JSON.parseObject(jedisCore.getVal(RedisKeyConfig.LOGIN_USER+token), TUser.class);
            List<TUserlikeStore> userlikeStores = likemapper.selectstores(user.getuId());
            return Rutil.Ok(userlikeStores);
        }
    }

    /**
     * 查询用户喜欢的所有明星穿搭
     * @param token
     * @return
     */
    @Override
    public R getstarstyles(String token) {
        if(jedisCore.isExist(RedisKeyConfig.LOGIN_USER+token)==false){
            return Rutil.err("请登录");
        }else {
            TUser user = JSON.parseObject(jedisCore.getVal(RedisKeyConfig.LOGIN_USER+token), TUser.class);
            List<TUserlikeStarStyle> userlikestars = likemapper.selectstar(user.getuId());
            return Rutil.Ok(userlikestars);
        }
    }

    /**
     * 删除用户喜欢
     * @param deleteUserlikeDto
     * @return
     */
    @Override
    public R dellike(DeleteUserlikeDto deleteUserlikeDto) {
        if(jedisCore.isExist(RedisKeyConfig.LOGIN_USER+deleteUserlikeDto.getToken())==false){
            return Rutil.err("请登录");
        }else {
            TUser user = JSON.parseObject(jedisCore.getVal(RedisKeyConfig.LOGIN_USER+deleteUserlikeDto.getToken()), TUser.class);
            if(userlikeMapper.delete(new QueryWrapper<TUserlike>().eq("l_id",deleteUserlikeDto.getId()))>0){
                return Rutil.Ok();
            }else {
                return Rutil.err("删除失败");
            }
        }
    }



}
