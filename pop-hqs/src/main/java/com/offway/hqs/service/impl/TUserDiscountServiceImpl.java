package com.offway.hqs.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.offway.common.entity.R;
import com.offway.common.entity.TDiscount;
import com.offway.common.entity.TUserDiscount;
import com.offway.common.mapper.TUserDiscountMapper;
import com.offway.common.three.JedisCore;
import com.offway.common.util.Rutil;
import com.offway.hqs.config.RedisKeyConfig;
import com.offway.hqs.dao.TUserDiscount2Mapper;
import com.offway.hqs.dto.LoginTokenDto;
import com.offway.hqs.service.ITUserDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/*
* 用户优惠券
*
* */
@Service("TUserDiscountServiceImplhqs")
public class TUserDiscountServiceImpl extends ServiceImpl<TUserDiscountMapper, TUserDiscount> implements ITUserDiscountService {
    @Resource
    private TUserDiscount2Mapper tUserDiscount2Mapper;
    @Resource
    private JedisCore jedisCore;

    @Override
    public R userdicountByid(String token) {
        //josn转换成logintokendato
        LoginTokenDto loginTokenDto=JSON.parseObject(jedisCore.getVal(RedisKeyConfig.LOGIN_USER+token),LoginTokenDto.class);
        System.out.println(loginTokenDto.getUid());

        return  Rutil.Ok(tUserDiscount2Mapper.selectUserdicountByid(loginTokenDto.getUid()));
    }
}
