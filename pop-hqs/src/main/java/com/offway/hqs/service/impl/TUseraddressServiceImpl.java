package com.offway.hqs.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.offway.common.conf.RedisKeyConfig;
import com.offway.common.entity.R;
import com.offway.common.entity.TUser;
import com.offway.common.entity.TUserAddress;
import com.offway.common.mapper.TUserAddressMapper;
import com.offway.common.three.JedisCore;
import com.offway.common.util.Rutil;
import com.offway.hqs.service.ITUseraddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TUseraddressServiceImpl extends ServiceImpl<TUserAddressMapper, TUserAddress> implements ITUseraddressService {
    @Autowired
    private JedisCore jedisCore;
    @Autowired
    private TUserAddressMapper tUserAddressMapper;

    @Override
    public R add(TUserAddress tUserAddress) {

        if (tUserAddressMapper.insert(tUserAddress) > 0) {
            return Rutil.Ok();
        } else {
            return Rutil.err();
        }
    }

    @Override
    public R select(String token) {
        TUser user = JSON.parseObject(jedisCore.getVal(RedisKeyConfig.LOGIN_USER + token), TUser.class);

        return Rutil.Ok(tUserAddressMapper.selectList(new QueryWrapper<TUserAddress>().eq("u_id", user.getuId())));
    }


}

