package com.offway.hqs.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.offway.common.entity.R;
import com.offway.common.entity.TUser;
import com.offway.common.entity.TUserDetails;
import com.offway.common.mapper.TUserDetailsMapper;
import com.offway.common.mapper.TUserMapper;
import com.offway.common.three.JedisCore;
import com.offway.common.util.Rutil;
import com.offway.hqs.config.RedisKeyConfig;
import com.offway.hqs.dao.TUserDetails2Mapper;
import com.offway.hqs.dto.LoginTokenDto;
import com.offway.hqs.dto.TUserDetailsDto;
import com.offway.hqs.service.ITUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TUserDetailsServiceImpl implements ITUserDetailsService {
    @Autowired
    private TUserMapper tUserMapper;
    @Autowired
    private JedisCore jedisCore;
    @Autowired
    private TUserDetailsMapper tUserDetailsMapper;
    @Autowired
    private TUserDetails2Mapper tUserDetails2Mapper;

    /*
     * 查询用户信息
     * */
    @Override
    public R selectUserdicountByid(String token) {
        //令牌模板
        LoginTokenDto loginTokenDto = JSON.parseObject(jedisCore.getVal(RedisKeyConfig.LOGIN_USER + token), LoginTokenDto.class);
        //查询用户
       // TUser tUser = tUserMapper.selectOne(new QueryWrapper<TUser>().eq("u_id", loginTokenDto.getUid()));
        //根据uid查询详情
        TUserDetails userDetails = tUserDetailsMapper.selectOne(new QueryWrapper<TUserDetails>().eq("u_id", loginTokenDto.getUid()));


        return Rutil.Ok(userDetails);
    }

    /*
     * 更新用户
     * */
    @Override
    public R updateUserDetails(TUserDetailsDto tdd) {
        TUserDetailsDto tUserDetailsDto = new TUserDetailsDto(tdd.getuId(), tdd.getUdName(), tdd.getUdSex(), tdd.getUdBrithday(), tdd.getUdHeight(), tdd.getUdWeight(), LocalDate.now());


        if (tUserDetails2Mapper.updateUserDetails(tUserDetailsDto) > 0) {
            return Rutil.Ok();

        } else {
            return Rutil.err();
        }

    }

    //新增用户详情
    @Override
    public R addUserDetails(TUserDetailsDto tdd) {
        TUserDetailsDto td = new TUserDetailsDto(tdd.getuId(), tdd.getUdName(), tdd.getUdSex(), tdd.getUdBrithday(), tdd.getUdHeight(), tdd.getUdHaardurl(), tdd.getUdWeight(), LocalDate.now());
        if (tUserDetails2Mapper.insertUserDetails(td) > 0) {
            return Rutil.Ok();
        } else {
            return Rutil.err();
        }

    }




}
