package com.offway.popzgy.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.offway.common.conf.RedisKeyConfig;
import com.offway.common.entity.R;
import com.offway.common.entity.TAdmindetail;
import com.offway.common.mapper.TAdminMapper;
import com.offway.common.mapper.TAdmindetailMapper;
import com.offway.common.three.JedisCore;
import com.offway.common.util.Rutil;
import com.offway.popzgy.dto.AdminDto;
import com.offway.popzgy.dto.AdminLoginTokenDto;
import com.offway.popzgy.service.TAdminDetailService;
import com.offway.popzgy.three.JwtCore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class TAdminDetailServiceImpl extends ServiceImpl<TAdmindetailMapper,TAdmindetail> implements TAdminDetailService {

    @Autowired
    private JedisCore jedisCore;
    @Autowired
    private TAdmindetailMapper admindetailMapper;
    @Autowired
    private TAdminMapper adminMapper;

        @Transactional //启用事务
        @Override
        public R login(AdminDto adminDto) {
            if(jedisCore.isExist(RedisKeyConfig.LOGIN_TOKEN+adminDto.getAName())){
                return Rutil.err("已经在线了，请勿再次登陆！");
            }else {
                TAdmindetail admindetail = admindetailMapper.selectOne(new QueryWrapper<TAdmindetail>().eq("a_name", adminDto.getAName()));
                if (admindetail != null) {
                    //查询密码
                    //先根据用户详情表的用户名查询ID
                    Integer aId=admindetailMapper.selectOne(new QueryWrapper<TAdmindetail>().eq("a_name",adminDto.getAName())).getaId();
                    if (adminDto.getAPassword().equals(adminMapper.selectById(aId).getaPassword())){
                        //正确
                        //生成令牌
                        AdminLoginTokenDto tokenDto = new AdminLoginTokenDto(aId,adminDto.getAName());
                        String token = JwtCore.createToken(JSON.toJSONString(tokenDto));
                        //记录令牌到Redis 有效期 30分钟
                        jedisCore.set(RedisKeyConfig.LOGIN_TOKEN + adminDto.getAName(), RedisKeyConfig.LOGIN_TOKEN_TIME,token);
                        jedisCore.set(RedisKeyConfig.LOGIN_USER + token, RedisKeyConfig.LOGIN_TOKEN_TIME, JSON.toJSONString(adminDto));
                        System.out.println(jedisCore.getVal(RedisKeyConfig.LOGIN_TOKEN + adminDto.getAName()));
                        System.out.println(RedisKeyConfig.LOGIN_USER + token);
                        return Rutil.Ok(token);

                    }
                }
            }
            return Rutil.err("账号或密码错误");
        }

    @Override
    public R exit(String token) {
        if(jedisCore.isExist(RedisKeyConfig.LOGIN_USER+token)){
            AdminDto adminDto=JSON.parseObject(jedisCore.getVal(RedisKeyConfig.LOGIN_USER+token),AdminDto.class);
            jedisCore.del(RedisKeyConfig.LOGIN_TOKEN+adminDto.getAName());
            jedisCore.del(RedisKeyConfig.LOGIN_USER+token);
            return Rutil.Ok();
        }else {
            return Rutil.err("令牌已失效");
        }
    }


}
