package com.offway.zyn.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.offway.common.conf.RedisKeyConfig;
import com.offway.common.entity.*;
import com.offway.common.mapper.*;
import com.offway.common.three.JedisCore;
import com.offway.common.util.Rutil;
import com.offway.zyn.dto.GoodDetail;
import com.offway.zyn.service.GoodDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

/**
 * @author starzyn
 * @className:GoodDetailServiceImpl
 * @date : 2020/6/25
 * @description: 商品详情的业务层实现类
 */
@Service
public class GoodDetailServiceImpl implements GoodDetailService {

    @Resource
    JedisCore jedisCore;
    @Resource
    TGoodsDetailMapper tGoodsDetailMapper;
    @Resource
    TStoreMapper tStoreMapper;
    @Resource
    TUserlikeMapper tUserlikeMapper;
    @Resource
    TShoppingCarMapper tShoppingCarMapper;
    @Resource
    TCommentUserMapper tCommentUserMapper;

    /**
     * @Author starzyn
     * @Description 展示商品详情页
     * @Date 14:17 2020/6/27
     * @Param [goodid, token]
     * @return com.offway.common.entity.R
     **/
    @Override
    public R show(int goodid, String token) {
        //查找商品详情
        TGoodsDetail tGoodsDetail = tGoodsDetailMapper.selectOne(new QueryWrapper<TGoodsDetail>().eq("t_goods_id",goodid));
        //查询商品对应的评论
        List<TCommentUser> tCommentUser = tCommentUserMapper.selectList(new QueryWrapper<TCommentUser>().eq("goods_id",goodid));
        //查询对应的店铺
        TStore tStore = tStoreMapper.selectOne(new QueryWrapper<TStore>().eq("s_id",tGoodsDetail.gettStoreId()));
        GoodDetail goodDetail = new GoodDetail(tGoodsDetail,tCommentUser,tStore);
        return Rutil.Ok(goodDetail);
    }

    @Override
    public R addLike(int goodid, String token) {
        //先检查是否登录
        boolean isLogin = jedisCore.isExist(RedisKeyConfig.LOGIN_USER+token);
        if(isLogin){//如果登陆了
            TUser user = JSONObject.parseObject(jedisCore.getVal(RedisKeyConfig.LOGIN_USER+token),TUser.class);
            int userId = user.getuId();//获取用户id
            boolean islike = jedisCore.isExist(userId+"like");
            if(islike){//如果缓存中存在
                TUserlike tUserlike = JSONObject.parseObject(jedisCore.getVal(userId+"like"),TUserlike.class);//从redis中获得喜欢的信息
                if(tUserlike.getgId()!=goodid) {//如果不相等
                    //转向数据库去查
                    TUserlike tUserlike1 = tUserlikeMapper.selectOne(new QueryWrapper<TUserlike>().eq("u_id",userId).eq("g_id",goodid));
                    if(tUserlike1==null){//如果数据库中不存在，则进行插入
                        tUserlike1.setuId(userId);
                        tUserlike1.setgId(goodid);
                        tUserlike1.setlCreateTime(LocalDate.now());
                        tUserlike1.setlStatus(1);
                        tUserlikeMapper.insert(tUserlike1);//插入该对象
                        //回写到缓存中
                        jedisCore.set(userId+"like",1*24*60*60,JSONObject.toJSONString(tUserlike1));
                        return Rutil.Ok(JSONObject.toJSONString(tUserlike1));
                    }else {//如果存在
                        return Rutil.err("已经添加到收藏！");
                    }
                }else{//如果缓存中的相等
                    return Rutil.err("已经添加到收藏！");
                }
            }else{//如果缓存中不存在
                TUserlike tUserlike1 = new TUserlike();
                tUserlike1.setuId(userId);
                tUserlike1.setgId(goodid);
                tUserlike1.setlCreateTime(LocalDate.now());
                tUserlike1.setlStatus(1);
                tUserlikeMapper.insert(tUserlike1);//插入该对象
                //回写到缓存中
                jedisCore.set(userId+"like",1*24*60*60,JSONObject.toJSONString(tUserlike1));
                return Rutil.Ok(JSONObject.toJSONString(tUserlike1));
            }
        }else{//如果没有登录
            return Rutil.err("请登录");
        }
    }

    @Override
    public R addCar(int goodid, String token) {
        //先检查是否登录
        boolean isLogin = jedisCore.isExist(RedisKeyConfig.LOGIN_USER+token);
        if(isLogin){//如果登陆了
            TUser user = JSONObject.parseObject(jedisCore.getVal(RedisKeyConfig.LOGIN_USER+token),TUser.class);
            int userId = user.getuId();//获取用户id
            TShoppingCar tShoppingCar = tShoppingCarMapper.selectOne(new QueryWrapper<TShoppingCar>().eq("u_id",userId).eq("goods_id",goodid));
            TGoodsDetail tGoodsDetail = tGoodsDetailMapper.selectOne(new QueryWrapper<TGoodsDetail>().eq("t_goods_id",goodid));
            if(tShoppingCar!=null){//该商品已经在购物车
                tShoppingCar.setScGoodsnum(tShoppingCar.getScGoodsnum()+1);//增加数量
                tShoppingCar.setScAllmoney(tGoodsDetail.gettGoodsCurPrice());//设置单价
                tShoppingCarMapper.insert(tShoppingCar);//向数据库插入数据
            }else{//如果数据库查询不到，就说明数据库中没有该商品的信息
                tShoppingCar.setuId(userId);
                tShoppingCar.setGoodsId(goodid);
                tShoppingCar.setScGoodsnum(1);//增加数量
                tShoppingCar.setScAllmoney(tGoodsDetail.gettGoodsCurPrice());//设置单价
                tShoppingCarMapper.insert(tShoppingCar);//向数据库插入数据
            }
            return Rutil.Ok("添加成功",null);
        }else{//如果没有登录
            return Rutil.err("请登录");
        }
    }
}
