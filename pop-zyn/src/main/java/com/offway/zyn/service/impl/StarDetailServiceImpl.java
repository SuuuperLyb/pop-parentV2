package com.offway.zyn.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.offway.common.conf.RedisKeyConfig;
import com.offway.common.entity.*;
import com.offway.common.mapper.*;
import com.offway.common.three.JedisCore;
import com.offway.common.util.Rutil;
import com.offway.zyn.dto.StarStyleDetail;
import com.offway.zyn.service.StarDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author starzyn
 * @className:StarDetailServiceImpl
 * @date : 2020/6/25
 * @description: 明星穿搭详情类的业务层实现类
 */
@Service
public class StarDetailServiceImpl implements StarDetailService {
    @Resource
    JedisCore jedisCore;
    @Resource
    TUserlikeMapper tUserlikeMapper;
    @Resource
    TStarMapper tStarMapper;
    @Resource
    TStoreMapper tStoreMapper;
    @Resource
    TStarStyleMapper tStarStyleMapper;
    @Resource
    TStarmetastyleMapper tStarmetastyleMapper;
    @Resource
    TGoodsDetailMapper tGoodsDetailMapper;
    @Resource
    TStylePhotosMapper tStylePhotosMapper;
    /**
     * @Author starzyn
     * @Description 点击按钮添加喜欢
     * @Date 18:04 2020/6/26
     * @Param [id, token]
     * @return com.offway.common.entity.R
     **/
    @Override
    public R addLike(int id, String token) {//id 是明星风格id
        boolean isLogin = jedisCore.isExist(RedisKeyConfig.LOGIN_USER+token);
        if(isLogin){
            //利用token来获取当前用户
            TUser user = JSONObject.parseObject(jedisCore.getVal(RedisKeyConfig.LOGIN_USER+token),TUser.class);
            int userId = user.getuId();//获取用户id
            boolean isExit = jedisCore.isExist(userId+"like");//从redis中查询是否有该用户的喜欢
            if(isExit){//如果存在
                TUserlike tUserlike = JSONObject.parseObject(jedisCore.getVal(userId+"like"),TUserlike.class);//从redis中获得喜欢的信息
                if(tUserlike.getStarId()==null){//如果不是明星风格喜欢
                    //转到数据库插入
                    tUserlike.setlCreateTime(LocalDate.now());
                    tUserlike.setStarId(id);
                    tUserlike.setlStatus(1);
                    tUserlike.setuId(userId);
                    tUserlikeMapper.insert(tUserlike);//插入数据
                    tUserlike = tUserlikeMapper.selectOne(new QueryWrapper<TUserlike>().eq("u_id",userId));//再查询出来
                    //放到redis中
                    jedisCore.set(userId+"like",2*24*60*60,JSONObject.toJSONString(tUserlike));//有效期两天
                    return Rutil.Ok(tUserlike);
                }
                //如果正是想要的数据
                return Rutil.Ok(tUserlike);
            }else {//如果不存在
                TUserlike tUserlike = new TUserlike();
                tUserlike.setlCreateTime(LocalDate.now());
                tUserlike.setStarId(id);
                tUserlike.setlStatus(1);
                tUserlike.setuId(userId);
                tUserlikeMapper.insert(tUserlike);//插入数据
                tUserlike = tUserlikeMapper.selectOne(new QueryWrapper<TUserlike>().eq("u_id",userId));//再查询出来
                //放到redis中
                jedisCore.set(userId+"like",2*24*60*60,JSONObject.toJSONString(tUserlike));//有效期两天
                return Rutil.Ok(tUserlike);
            }
        }else {//如果未登录
            return  Rutil.err("未登录");
        }
    }

    /**
     * @Author starzyn
     * @Description 用户取消喜欢
     * @Date 21:06 2020/6/26
     * @Param [id, token]
     * @return com.offway.common.entity.R
     **/
    @Override
    public R dislike(int id, String token) {
        boolean isLogin = jedisCore.isExist(RedisKeyConfig.LOGIN_USER+token);
        if(isLogin){
            //利用token来获取当前用户
            TUser user = JSONObject.parseObject(jedisCore.getVal(RedisKeyConfig.LOGIN_USER+token),TUser.class);
            int userId = user.getuId();//获取用户id
            boolean isExit = jedisCore.isExist(userId+"like");//从redis中查询是否有该用户的喜欢
            boolean falgToDB = false;//转去数据库删除的标志位
            if(isExit){//如果存在
                TUserlike tUserlike = JSONObject.parseObject(jedisCore.getVal(userId+"like"),TUserlike.class);//从redis中获得喜欢的信息
                if(tUserlike.getStarId()==null){//如果不是明星风格喜欢
                    falgToDB = true;
                }else {
                    //如果正是想要的数据,删除掉
                    jedisCore.del(userId + "like");
                    falgToDB = false;
                }
            }else {//如果不存在
                falgToDB = true;
            }
            if(falgToDB){
                //数据库删除
                tUserlikeMapper.delete(new UpdateWrapper<TUserlike>().eq("u_id",userId).eq("star_id",id));
            }
            return Rutil.Ok();
        }else {//如果未登录
            return  Rutil.err("未登录");
        }
    }

    @Override
    public R showDetail(int starStyleId) {
        boolean isExist = jedisCore.isExist("starStyleDEtail"+starStyleId);
        if(isExist){//如果存在
            StarStyleDetail starStyleDetail = JSONObject.parseObject(jedisCore.getVal("starStyleDEtail"+starStyleId),StarStyleDetail.class);
            return Rutil.Ok(starStyleDetail);
        }else {//如果不存在，转到数据库查询并添加到缓存中
            //查询风格的详情
            TStarStyle tStarStyle = tStarStyleMapper.selectOne(new QueryWrapper<TStarStyle>().eq("star_style_id",starStyleId));
            //查询对应的明星风格图片信息
            List<TStylePhotos> list = tStylePhotosMapper.selectList(new QueryWrapper<TStylePhotos>().eq("stat_style_id",tStarStyle.getStarStyleId()));
            //查询对应的明星信息
            TStar star = tStarMapper.selectOne(new QueryWrapper<TStar>().eq("id",tStarStyle.getStarId()));
            TStarmetastyle tStarmetastyle = tStarmetastyleMapper.selectOne(new QueryWrapper<TStarmetastyle>().eq("star_id",star.getId()).eq("style_id",tStarStyle.getStyleId()));
            //根据tStarmetastyle获取商品id后查询对应商品
            TGoodsDetail good = tGoodsDetailMapper.selectOne(new QueryWrapper<TGoodsDetail>().eq("t_goods_id",tStarmetastyle.getGoodId()));
            //根据查询到的商品获得对应的店铺信息
            TStore tStore = tStoreMapper.selectOne(new QueryWrapper<TStore>().eq("s_id",good.gettStoreId()));
            //封装查询的对象
            StarStyleDetail starStyleDetail = new StarStyleDetail(tStarStyle,star,tStore,good,list);
            //写回缓存中
            jedisCore.set("starStyleDEtail",1*24*60*60,JSONObject.toJSONString(starStyleDetail));
            return Rutil.Ok(starStyleDetail);
        }
    }
}
